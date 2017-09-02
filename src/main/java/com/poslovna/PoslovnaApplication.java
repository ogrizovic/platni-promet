package com.poslovna;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PoslovnaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoslovnaApplication.class, args);
//		configureApplication(new SpringApplicationBuilder()).run(args);
	}
	
//	private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
//        return builder.sources(PoslovnaApplication.class);
//    }
	
}
