package src.test.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaUserServiceApplication.class, args);
	}

}
