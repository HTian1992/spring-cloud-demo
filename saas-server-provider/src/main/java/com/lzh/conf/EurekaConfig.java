package com.lzh.conf;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EurekaConfig extends EurekaClientConfigBean{
	private Map<String, String> serviceUrl = new HashMap<>();

	{
		this.serviceUrl.put(DEFAULT_ZONE, "http://127.0.0.1:8761" + DEFAULT_PREFIX);
	}
}
