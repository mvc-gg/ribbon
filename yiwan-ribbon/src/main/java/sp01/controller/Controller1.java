package sp01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
@RestController
public class Controller1 {
	@Autowired
RestTemplate rest;
	
	@RequestMapping("/port")
	@HystrixCommand(fallbackMethod = "getPort")//降级（后台访问出现异常）后会执行该方法的代码
	public String item() {
		return rest.getForObject("http://item-service/page", String.class);	
	}
	public String getPort() {
		return "失败获取port";
	}
}
