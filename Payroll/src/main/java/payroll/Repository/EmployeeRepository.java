package payroll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payroll.POJO.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> { }