package cz.juskiewi.databasemicroservice.controller;

import cz.juskiewi.databasemicroservice.model.Customer;
import cz.juskiewi.databasemicroservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @GetMapping("/customers")
    public List<Customer> retrieveCustomer() {

        List<Customer> customers = repository.findAll();

        return customers;
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {

        repository.save(customer);

        return customer;

    }
}
