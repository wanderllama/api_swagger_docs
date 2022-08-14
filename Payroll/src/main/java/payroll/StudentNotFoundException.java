package payroll;

public class StudentNotFoundException extends RuntimeException{

    StudentNotFoundException(Long id) {
        super("Could Not Find Student " + id);
    }

    StudentNotFoundException(String substr) {
        super("Could Not Find Any Student Name Containing \"" + substr + "\"");
    }
}
