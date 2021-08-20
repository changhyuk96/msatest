package src.test.gate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("src.test.gate.user")
public class EurekaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaGatewayApplication.class, args);
	}

}
