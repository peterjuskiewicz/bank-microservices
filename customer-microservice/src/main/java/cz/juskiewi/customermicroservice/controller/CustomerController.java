package cz.juskiewi.customermicroservice.controller;

import com.netflix.discovery.converters.Auto;
import cz.juskiewi.customermicroservice.model.Customer;
import cz.juskiewi.customermicroservice.proxy.DatabaseServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DatabaseServiceProxy proxy;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {


        List<Customer> customers = proxy.retreiveCustomers();

        logger.info("{}", customers);

        return customers;


    }

    @PostMapping("customers")
    public Customer createCustomer(@RequestBody Customer customer) {

        logger.info("{}", customer);

        Customer createdCustomer = proxy.createCustomer(customer);

        return createdCustomer;

    }

}
