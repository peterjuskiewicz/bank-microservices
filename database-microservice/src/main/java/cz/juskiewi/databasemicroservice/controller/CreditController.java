package cz.juskiewi.databasemicroservice.controller;

import cz.juskiewi.databasemicroservice.model.Credit;
import cz.juskiewi.databasemicroservice.repository.CreditRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CreditController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CreditRepository repository;

    @GetMapping("/credits")
    public List<Credit> retreiveCredits() {


        List<Credit> credits = repository.findAll();

        return credits;
    }


    @PostMapping("/credits")
    public Credit createCredit(@RequestBody Credit credit) {

        logger.info("{}", credit.toString());

        Credit savedCredit = repository.save(credit);


        return savedCredit;
    }

}
