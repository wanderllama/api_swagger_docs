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
            log.info("Preloading " + repository.save(new Employee("Layla", "Soft Skills")));
            log.info("Preloading " + repository.save(new Employee("Aysun", "Selenium")));
            log.info("Preloading " + repository.save(new Employee("Mehmet", "Database/JDBC")));
            log.info("Preloading " + repository.save(new Employee("Murodil", "API")));
            log.info("Preloading " + repository.save(new Employee("Austin", "Support")));
            // Students
            log.info("Preloading " + repository2.save(new Student("James" , "Wallace" , "B6" , 5712353459L)));
            log.info("Preloading " + repository2.save(new Student("Shakhzoda" , "Kamilova" , "B6" , 5553456709L)));
            log.info("Preloading " + repository2.save(new Student("Gulie" , "Shokret" , "B6" , 6475846305L)));
            log.info("Preloading " + repository2.save(new Student("Jelena" , "Petrovic" , "B6" , 5712568777L)));
            log.info("Preloading " + repository2.save(new Student("Olya" , "Grechyna" , "B6" , 57512157841L)));
            log.info("Preloading " + repository2.save(new Student("Asia" , "Bizub" , "B6" , 7737745959L)));
        };
    }
}
