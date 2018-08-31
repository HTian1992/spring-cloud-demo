package com.lzh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

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

	@GetMapping("/erk")
	public String getErkInfo(HttpServletRequest request) {
		return "请求地址为:"+request.getLocalAddr()+":"+"返回信息：hello !!";
	}
}
