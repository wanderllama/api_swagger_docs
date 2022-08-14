package payroll;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}