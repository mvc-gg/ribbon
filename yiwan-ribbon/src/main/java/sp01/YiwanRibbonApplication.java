package sp01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class YiwanRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(YiwanRibbonApplication.class, args);
	}
	@LoadBalanced
	@Bean
public RestTemplate getInstance() {
		SimpleClientHttpRequestFactory f=new SimpleClientHttpRequestFactory();
		f.setConnectTimeout(1000);//连接超时时间
		f.setReadTimeout(1000);//等待结果超时时间
	return new RestTemplate(f);
}
}
