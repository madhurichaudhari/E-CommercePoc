package com.hcl.ecommercepoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author MadhuriC
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class ECommercePocApplication  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ECommercePocApplication.class, args);
		System.out.println("running");
	}

}
