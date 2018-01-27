package eu.kasprzaksolutions.service;

import eu.kasprzaksolutions.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

private List<Customer> customers = new ArrayList(Arrays.asList(
        new Customer("Stefan","Telefan"),
        new Customer("Grzegorz","Brzeczyszczykiewicz")
));

}
