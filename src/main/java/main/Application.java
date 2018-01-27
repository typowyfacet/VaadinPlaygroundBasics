package main;

import entities.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import repositories.CustomerRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "repositories")
@EntityScan(basePackages = "entities")
@EnableTransactionManagement

//@ImportResource("classpath:applicationContext.xml")
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {

        customerRepository.save(new Customer("Stefan", "Telefan"));
        customerRepository.save(new Customer("Siara", "Siarzewski"));

        logger.info("Customers found by findAll");
        for (Customer customer : customerRepository.findAll()
                ) {
            logger.info(customer.toString());
        }
        logger.info(" ");


        logger.info("Customers found by name");
        for (Customer customer : customerRepository.findByNameIgnoreCase("siAra")) {
            logger.info(customer.toString());
        }
    }

    ;
}

