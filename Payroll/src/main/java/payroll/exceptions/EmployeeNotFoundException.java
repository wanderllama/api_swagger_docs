package payroll.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("Could Not Find Employee " + id);
    }

    public EmployeeNotFoundException(String substr) {
        super("Could Not Find Any Employees Name Containing \"" + substr + "\"");
    }
}