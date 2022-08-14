package payroll;

class EmployeeNotFoundException extends RuntimeException {

    EmployeeNotFoundException(Long id) {
        super("Could Not Find Employee " + id);
    }

    EmployeeNotFoundException(String substr) {
        super("Could Not Find Any Employees Name Containing \"" + substr + "\"");
    }
}