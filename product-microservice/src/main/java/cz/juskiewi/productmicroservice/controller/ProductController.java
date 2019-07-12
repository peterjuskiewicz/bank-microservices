package cz.juskiewi.productmicroservice.controller;

import cz.juskiewi.productmicroservice.model.Product;
import cz.juskiewi.productmicroservice.proxy.DatabaseServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DatabaseServiceProxy proxy;

    @GetMapping("/products")
    public List<Product> getProducts() {

        return proxy.retreiveProducts();

    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {

        logger.info("{}", product);

        return proxy.createProduct(product);

    }
}
