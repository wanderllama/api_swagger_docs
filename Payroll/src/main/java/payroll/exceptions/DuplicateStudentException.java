package payroll.exceptions;

public class DuplicateStudentException extends RuntimeException {

    public DuplicateStudentException() {
        super("This Student Has Already Been Added");
    }
}
