package cz.juskiewi.customermicroservice.proxy;

import cz.juskiewi.customermicroservice.model.Customer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "database-microservice", url = "localhost:8000")
//@RibbonClient(name = "database-microservice")
public interface DatabaseServiceProxy {

    @GetMapping("/customers")
    public List<Customer> retreiveCustomers();

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer);


}