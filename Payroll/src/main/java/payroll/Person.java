package payroll;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
class Person {

    private @Id @GeneratedValue Long id;

    private String firstName;
    private String lastName;
    private String role;
    private Long mobile;

    public Person() {}

    Person(String firstName , String lastName , String role, Long mobile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
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

    public String getRole() {
        return this.role;
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

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Person))
            return false;
        Person person = (Person) o;
        return Objects.equals(this.id , person.id) && Objects.equals(this.firstName , person.firstName) && Objects.equals(this.lastName , person.lastName) && Objects.equals(this.role , person.role) && Objects.equals(this.mobile , person.mobile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id , this.firstName , this.lastName , this.role , this.mobile);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
