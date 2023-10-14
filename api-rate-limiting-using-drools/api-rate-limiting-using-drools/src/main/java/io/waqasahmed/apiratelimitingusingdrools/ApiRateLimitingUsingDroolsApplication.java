package io.waqasahmed.apiratelimitingusingdrools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableAutoConfiguration
public class ApiRateLimitingUsingDroolsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ApiRateLimitingUsingDroolsApplication.class, args);
		boolean isBeanInstantiated = context.containsBean("PersonRepository");
	}

}
