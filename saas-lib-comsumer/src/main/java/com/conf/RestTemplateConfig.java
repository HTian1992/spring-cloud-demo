package com.conf;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	/**
	* LoadBalanced注解必须加上，以实现客户端负载均衡
	* */
	@Bean
	@LoadBalanced
	@Primary
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
