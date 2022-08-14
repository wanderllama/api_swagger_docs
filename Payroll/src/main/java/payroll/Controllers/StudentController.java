package payroll.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import payroll.POJO.Student;
import payroll.Repository.StudentRepository;
import payroll.exceptions.InvalidStudentException;
import payroll.exceptions.StudentNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/students")
    List<Student> all() {
        return repository.findAll();
    }

    @PostMapping("/students")
    Student newPerson(@RequestBody Student newStudent) {
        return repository.save(newStudent);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
//    @GetMapping("/employees/{id}")
    Student getByID(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @GetMapping("/students/search")
    ResponseEntity<List<Student>> search (@RequestParam("nameContains") String substr) {
        List<Student> partialEmployees = repository.findAll().stream().filter(student -> student.getFullName().toLowerCase().contains(substr)).collect(Collectors.toList());
        if (partialEmployees.size() == 0) {
            throw new StudentNotFoundException(substr);
        } else {
            return ResponseEntity.ok(partialEmployees);
        }
    }

    @PutMapping("/students/{id}")
    Student replaceStudent(@RequestBody Student newStudent , @PathVariable Long id) {
        return repository.findById(id)
                .map(student -> {
                    validStudentData(newStudent.getMobile().toString() , newStudent.getBatch());
                    student.setFirstName(newStudent.getFirstName());
                    student.setLastName(newStudent.getLastName());
                    student.setBatch(newStudent.getBatch());
                    student.setMobile(newStudent.getMobile());
                    return repository.save(newStudent);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return repository.save(newStudent);
                });
    }

    @DeleteMapping("/student/{id}")
    void deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
    }


    private static void validStudentData(String mobile , String batch) {
        boolean mobileValid = mobile.matches("^\\\\d{10}$");
        boolean batchValid = batch.matches("B\\d*");
            if (!mobileValid && !batchValid) {
                throw new InvalidStudentException();
            } else if (!mobileValid) {
                throw new InvalidStudentException(newStudent.getMobile());
            } else if (!batchValid) {
                throw new InvalidStudentException(newStudent.getBatch());
            }
    }
}