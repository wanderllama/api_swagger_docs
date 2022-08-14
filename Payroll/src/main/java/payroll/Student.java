package payroll;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
class Student {

    private @Id @GeneratedValue Long id;

    private String firstName;
    private String lastName;
    private String batch;
    private Long mobile;

    public Student() {}

    Student(String firstName , String lastName , String batch , Long mobile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.batch = batch;
        this.mobile = mobile;
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getBatch() {
        return batch;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Student))
            return false;
        Student student = (Student) o;
        return Objects.equals(this.id , student.id) && Objects.equals(this.firstName , student.firstName) && Objects.equals(this.lastName , student.lastName) && Objects.equals(this.batch , student.batch) && Objects.equals(this.mobile , student.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id , this.firstName , this.lastName , this.batch , this.mobile);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", batch='" + batch + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
