package payroll.exceptions;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(Long id) {
        super("Could Not Find Student " + id);
    }

    public StudentNotFoundException(String substr) {
        super("Could Not Find Any Student Name Containing \"" + substr + "\"");
    }
}
