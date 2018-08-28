package com.lzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@SpringCloudApplication
@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
public class ServerApplication {

	public static void main(String[] args) {  
	    SpringApplication.run(ServerApplication.class, args);
	  }
}
