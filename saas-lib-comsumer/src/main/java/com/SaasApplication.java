package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@SpringCloudApplication
@SpringBootApplication
@EnableEurekaClient
//超时机制、断路器模式
@EnableCircuitBreaker
public class SaasApplication {

	public static void main(String[] args) {  
	    SpringApplication.run(SaasApplication.class, args);
	  }
}
