package com.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class MyHystrixClient {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "myFallback")
    public String simpleHystrixClientCall(long time) {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("time", time);
        return restTemplate.getForObject( "http://zwy-gtpw/lzh?time={time}", String.class,uriVariables);
    }

    /**
     * 方法simpleHystrixClientCall的回退方法，可以指定将hystrix执行失败异常传入到方法中
     *
     * @param p ystrix执行失败的传入方法的请求
     * @param e hystrix执行失败的异常对象
     * @return
     */
    String myFallback(long p, Throwable e) {
        return "Execute raw fallback: access service fail , req= " + p + " reason = " + e;
    }


}
