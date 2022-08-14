package payroll;

public class InvalidStudentException extends RuntimeException{

    InvalidStudentException() {
        super("Could Not Add Student\nInvalid Mobile And Batch Format\nMobile Must Be Between 10-13 Numbers And Batch Must Start With 'B'");
    }
    InvalidStudentException(String batch) {
        super("Could Not Add Student\nInvalid Batch Format\nMust Start With 'B' then followed by batch number");
    }

    InvalidStudentException(Long mobile) {
        super("Could Not Add Student\nInvalid Mobile Format\nMobile Must Be Between 10-13 Numbers");
    }
}
