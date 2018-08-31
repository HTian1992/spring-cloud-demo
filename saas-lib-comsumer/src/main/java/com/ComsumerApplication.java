package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@SpringCloudApplication
@SpringBootApplication
@EnableEurekaClient
//超时机制、断路器模式，使服务在不可用时，自动降级，返回fallback
@EnableCircuitBreaker
public class ComsumerApplication {

	public static void main(String[] args) {  
	    SpringApplication.run(ComsumerApplication.class, args);
	  }
}
