package cz.juskiewi.creditmicroservice.proxy;


import cz.juskiewi.creditmicroservice.model.Customer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "customer-microservice",url = "localhost:8200")
//@RibbonClient(name = "customer-microservice")
public interface CustomerServiceProxy {

    @GetMapping("/customers")
    public List<Customer> getCustomers();

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer);
}
