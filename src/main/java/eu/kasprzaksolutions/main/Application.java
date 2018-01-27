package eu.kasprzaksolutions.main;

import eu.kasprzaksolutions.entities.Customer;
import eu.kasprzaksolutions.repositories.CustomerRepository;
import eu.kasprzaksolutions.service.CustomerService;
import eu.kasprzaksolutions.ui.HelloUi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
        (scanBasePackages="eu.kasprzaksolutions")
@EnableJpaRepositories(basePackages = "eu.kasprzaksolutions.repositories")
@EntityScan(basePackages = "eu.kasprzaksolutions.entities")

@EnableTransactionManagement
//@ImportResource("classpath:applicationContext.xml")
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    @Autowired
    private CustomerRepository customerRepository;
//    @Autowired
//    private CustomerService customerService;
//

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

