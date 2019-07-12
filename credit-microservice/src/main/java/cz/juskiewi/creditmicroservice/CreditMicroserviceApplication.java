package cz.juskiewi.creditmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients("cz.juskiewi.creditmicroservice")
public class CreditMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditMicroserviceApplication.class, args);
	}

}
