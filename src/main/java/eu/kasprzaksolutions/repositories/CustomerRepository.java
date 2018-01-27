package eu.kasprzaksolutions.repositories;

import eu.kasprzaksolutions.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByNameIgnoreCase(String name);

}
