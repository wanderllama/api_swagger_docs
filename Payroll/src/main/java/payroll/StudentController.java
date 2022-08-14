package payroll;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    Student one(@PathVariable Long id) {
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
}