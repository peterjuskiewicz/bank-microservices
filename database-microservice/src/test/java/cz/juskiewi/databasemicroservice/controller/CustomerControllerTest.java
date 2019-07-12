package cz.juskiewi.databasemicroservice.controller;


import cz.juskiewi.databasemicroservice.controller.CustomerController;
import cz.juskiewi.databasemicroservice.model.Customer;
import cz.juskiewi.databasemicroservice.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerRepository customerRepository;



    @Test
    public void testControllerGet() {

        when(customerRepository.findAll()).thenReturn(Arrays.asList(new Customer(1, "firstTest", "1234567891", "lastTest")));

        List<Customer> customers = customerController.retrieveCustomer();

        assertEquals(1, customers.get(0).getCreditId());


    }


}
