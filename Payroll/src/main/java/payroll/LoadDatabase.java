package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import payroll.POJO.Employee;
import payroll.POJO.Student;
import payroll.Repository.EmployeeRepository;
import payroll.Repository.StudentRepository;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository , StudentRepository repository2) {

        return args -> {
            //Employees
            log.info("Preloading " + repository.save(new Employee("Siam", "Java")));
            log.info("Preloading " + repository.save(new Employee("Nadir", "Soft Skills")));
            log.info("Preloading " + repository.save(new Employee("Aysun", "Selenium")));
            log.info("Preloading " + repository.save(new Employee("Mehmet", "Database/JDBC")));
            log.info("Preloading " + repository.save(new Employee("Murodil", "API")));
            log.info("Preloading " + repository.save(new Employee("Austin", "Support")));
            // Students
            log.info("Preloading " + repository2.save(new Student("James" , "Wallace" , "B26" , 5712353459L)));
            log.info("Preloading " + repository2.save(new Student("Shakhzoda" , "Kamilova" , "B26" , 5553456789L)));
            log.info("Preloading " + repository2.save(new Student("Gulie" , "Shokret" , "B26" , 6475846325L)));
            log.info("Preloading " + repository2.save(new Student("Jelena" , "Petrovic" , "B26" , 7737179130L)));
        };
    }
}