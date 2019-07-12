package cz.juskiewi.databasemicroservice.data;


import cz.juskiewi.databasemicroservice.model.Customer;
import cz.juskiewi.databasemicroservice.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void testFindAll() {

        List<Customer> customers = customerRepository.findAll();

        assertEquals(1001, customers.get(0).getCreditId());
    }
}
