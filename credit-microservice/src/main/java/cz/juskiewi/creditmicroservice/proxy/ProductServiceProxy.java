package cz.juskiewi.creditmicroservice.proxy;


import cz.juskiewi.creditmicroservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product-microservice", url = "localhost:8300")
public interface ProductServiceProxy {


    @GetMapping("/products")
    public List<Product> getProducts();


    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product);


}
