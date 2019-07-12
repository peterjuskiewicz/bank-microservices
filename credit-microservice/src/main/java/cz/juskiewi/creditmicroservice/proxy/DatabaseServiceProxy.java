package cz.juskiewi.creditmicroservice.proxy;

import cz.juskiewi.creditmicroservice.model.Credit;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "database-microservice", url = "localhost:8000")
//@RibbonClient(name = "database-microservice")
public interface DatabaseServiceProxy {

    @GetMapping("/credits")
    public List<Credit> retreiveCredits();

    @PostMapping("/credits")
    public Credit createCredit(@RequestBody Credit credit);


}
