package payroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payroll.POJO.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}