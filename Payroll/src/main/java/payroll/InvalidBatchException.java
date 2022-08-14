package payroll;

public class InvalidBatchException extends RuntimeException{

    InvalidBatchException() {
        super("Could Not Add Student Invalid Batch Format\nMust Start With 'B' then followed by batch number");
    }
}
