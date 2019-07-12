package cz.juskiewi.creditmicroservice.controller;

import cz.juskiewi.creditmicroservice.model.Credit;
import cz.juskiewi.creditmicroservice.model.CreditObject;
import cz.juskiewi.creditmicroservice.model.Customer;
import cz.juskiewi.creditmicroservice.model.Product;
import cz.juskiewi.creditmicroservice.proxy.CustomerServiceProxy;
import cz.juskiewi.creditmicroservice.proxy.DatabaseServiceProxy;
import cz.juskiewi.creditmicroservice.proxy.ProductServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class CreditController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DatabaseServiceProxy databaseProxy;

    @Autowired
    CustomerServiceProxy customerProxy;

    @Autowired
    ProductServiceProxy productProxy;

    @GetMapping("/credits")
    public List<CreditObject> getCredits() {

        List<CreditObject> creditObjects = new ArrayList<>();

        List<Credit> credits = databaseProxy.retreiveCredits();

        List<Customer> customers = customerProxy.getCustomers();

        List<Product> products = productProxy.getProducts();

        credits.forEach(credit -> {

            CreditObject creditObject = new CreditObject();
            creditObject.setCredit(credit);

            Product product = products.stream()
                    .filter(prod -> credit.getId() == prod.getCreditId())
                    .findAny()
                    .orElse(null);

            creditObject.setProduct(product);

            Customer customer = customers.stream()
                    .filter(cust -> credit.getId() == cust.getCreditId())
                    .findAny()
                    .orElse(null);

            creditObject.setCustomer(customer);

            creditObjects.add(creditObject);

        });


        return creditObjects;
    }

    @PostMapping("/credits")
    public Credit createCredit(@RequestBody CreditObject creditObject) {

        Credit credit = creditObject.getCredit();

        Customer customer = creditObject.getCustomer();

        Product product = creditObject.getProduct();

        Credit createdCredit = databaseProxy.createCredit(credit);

        customer.setCreditId(createdCredit.getId());
        customerProxy.createCustomer(customer);

        product.setCreditId(createdCredit.getId());
        productProxy.createProduct(product);

        return createdCredit;
    }


}
