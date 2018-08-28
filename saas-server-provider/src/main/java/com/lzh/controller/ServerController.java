package com.lzh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

	/*@Autowired
	private ApplicationProperties applicationProperties;*/
	
	@Value("${zwy.global.conf.redis.host}")
	private String profile;
	@Value("${zwy.global.conf.redis.password}")
	private String test;
	@Value("${spring.batch.job.enabled}")
	private boolean rs;
	
	static int i = 1;
	
	private Thread thread = new Thread();

	@GetMapping("/lzh")
	public String test(@RequestParam long time) {
		try {
			System.out.println("超时服务降级测试,等待"+time+"毫秒");
			Thread.sleep(time);
		}catch (Exception e){
		}
		return "Hello world";
	}

	@GetMapping("/profile")
	public String getProfile() {
		return profile;
	}

	
	@GetMapping("/test")
	public String getTest() {
		return test;
	}
	
	@GetMapping("/erk")
	public String getErkInfo(HttpServletRequest request) {
		return ""+request.getRemoteAddr()+":"+request.getRemotePort()+"返回信息：hello !!";
	}
	
	@GetMapping("/simple")
	public String getsimple(HttpServletRequest request) throws InterruptedException {
		if (i==1) {
			i++;
			return "" + request.getRemoteAddr() + ":" + request.getRemotePort() + ",测试熔断器!!";
		} else {
			System.out.println("i = " +i);
			thread.sleep(10*1000);
			System.out.println("i = " +(i++));
			return null;
		}
	}
}
