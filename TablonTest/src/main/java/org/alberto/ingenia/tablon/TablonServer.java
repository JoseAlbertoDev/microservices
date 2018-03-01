package org.alberto.ingenia.tablon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TablonServer {

	public static void main(String[] args) {
		SpringApplication.run(TablonServer.class, args);
	}

}
