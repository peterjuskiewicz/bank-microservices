package cz.juskiewi.databasemicroservice.controller;

import cz.juskiewi.databasemicroservice.model.Product;
import cz.juskiewi.databasemicroservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> retreiveProducts() {

        List<Product> products = productRepository.findAll();

        return products;

    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {

        productRepository.save(product);

        return product;
    }



}
