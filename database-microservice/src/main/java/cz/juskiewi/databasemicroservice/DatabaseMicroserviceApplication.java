package cz.juskiewi.databasemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DatabaseMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseMicroserviceApplication.class, args);
	}

}
