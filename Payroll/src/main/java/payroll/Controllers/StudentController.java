package payroll.Controllers;

import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import payroll.POJO.Student;
import payroll.Repository.StudentRepository;
import payroll.exceptions.DuplicateStudentException;
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
    @Description("GET a list of all students")
    List<Student> all() {
        return repository.findAll();
    }

    @PostMapping("/students")
    Student newPerson(@RequestBody Student newStudent) {
        studentDataValidation(newStudent.getMobile() , newStudent.getBatch());
        checkForDuplicates(newStudent);
        return repository.save(newStudent);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
//    @GetMapping("/employees/{id}")
    Student getByID(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @GetMapping("/students/search")
    ResponseEntity<List<Student>> search(@RequestParam("nameContains") String substr) {
        List<Student> partialEmployees = repository.findAll().stream().filter(student -> student.getFullName().toLowerCase().contains(substr)).collect(Collectors.toList());
        if (partialEmployees.size() == 0) {
            throw new StudentNotFoundException(substr);
        } else {
            return ResponseEntity.ok(partialEmployees);
        }
    }

    @PutMapping("/students/{id}")
    Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {
        return repository.findById(id)
                .map(student -> {
                    studentDataValidation(newStudent.getMobile() , newStudent.getBatch());
                    checkForDuplicates(newStudent);
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

    private static void studentDataValidation(long mobile, String batch) {
        String mobileString = String.valueOf(mobile);
        boolean mobileValid = mobileString.matches("^\\d{10}$");
        boolean batchValid = batch.matches("B\\d*");
        if (!mobileValid && !batchValid) {
            throw new InvalidStudentException();
        } else if (!mobileValid) {
            throw new InvalidStudentException(mobile);
        } else if (!batchValid) {
            throw new InvalidStudentException(batch);
        }
    }

    private void checkForDuplicates(Student newStudent) {
        List<Student> allStudents = this.repository.findAll();
        List<Student> matchingFullName = allStudents.stream().filter(student -> student.getFullName().equals(newStudent.getFullName())).collect(Collectors.toList());
        if (matchingFullName.size() != 0) {
            List<Student> matchingBatch = matchingFullName.stream().filter(student -> student.getBatch().equals(newStudent.getBatch())).collect(Collectors.toList());
            if (matchingBatch.size() != 0) {
                List<Student> matchingMobile = matchingBatch.stream().filter(student -> student.getMobile().equals(newStudent.getMobile())).collect(Collectors.toList());
                if (matchingMobile.size() != 0) {
                    throw new DuplicateStudentException();
                }
            }
        }
    }
}
