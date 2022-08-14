package payroll.exceptions;

public class InvalidStudentException extends RuntimeException{

    public InvalidStudentException() {
        super("Could Not Add Student\nInvalid Mobile And Batch Format\nMobile Must Be Between 10-13 Numbers And Batch Must Start With 'B'");
    }
    public InvalidStudentException(String batch) {
        super("Could Not Add Student\nInvalid Batch Format\nMust Start With 'B' then followed by batch number");
    }

    public InvalidStudentException(Long mobile) {
        super("Could Not Add Student\nInvalid Mobile Format\nMobile Must Be Between 10-13 Numbers");
    }
}
