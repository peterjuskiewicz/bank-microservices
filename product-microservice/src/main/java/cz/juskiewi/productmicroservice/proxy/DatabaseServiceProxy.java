package cz.juskiewi.productmicroservice.proxy;

import cz.juskiewi.productmicroservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "database-microservice", url = "localhost:8000")
//@RibbonClient(name = "database-microservice")
public interface DatabaseServiceProxy {


    @GetMapping("/products")
    public List<Product> retreiveProducts();


    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product);


}
