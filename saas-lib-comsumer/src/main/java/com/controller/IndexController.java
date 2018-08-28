package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class IndexController {

	/*@Autowired
	private ApplicationProperties applicationProperties;*/
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/geterk")
	public String getErkInfo(HttpServletRequest request) {
		String rest = restTemplate.exchange( "http://zwy-gtpw/test", HttpMethod.GET, null, new ParameterizedTypeReference<String>() { }).getBody();
		return "web端从服务端获取的信息:"+rest;
	}
	
	@GetMapping("/geterk2")
	public String getErkInfo2(HttpServletRequest request) {
		String rest = restTemplate.exchange( "http://zwy-gtpw/erk", HttpMethod.GET, null, new ParameterizedTypeReference<String>() { }).getBody();
		return "web端从服务端获取的信息:"+rest;
	}
	
	 @GetMapping("/simple")
	 @HystrixCommand(fallbackMethod = "findByIdFallback")
	 public String findById() {
	        // http://localhost:7900/simple/
	        // VIP：virtual IP
	        // HAProxy Heartbeat
	      return restTemplate.getForObject("http://zwy-gtpw/simple", String.class);
	 }
	 
	 public String findByIdFallback() {
	        return "熔断器直接返回异常信息";
	    }
}
