package payroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository , StudentRepository repository2) {

        return args -> {
            log.info("Preloading " + repository.save(new Employee("Siam", "Java")));
            log.info("Preloading " + repository.save(new Employee("Nadir", "Soft Skills")));
            log.info("Preloading " + repository.save(new Employee("Aysun", "Selenium")));
            log.info("Preloading " + repository.save(new Employee("Mehmet", "Database/JDBC")));
            log.info("Preloading " + repository.save(new Employee("Murodil", "API")));
            log.info("Preloading " + repository.save(new Employee("Austin", "Support")));
            log.info("Preloading " + repository2.save(new Student("james" , "wallace" , "B26" , 5712353459L)));
        };
    }
}