package com.ljtao3.consumeruser;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@EnableDiscoveryClient //开启发现服务功能
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker//开启断路器hystrix
public class ConsumerUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerUserApplication.class, args);
    }

    /**
     * 创建指定字符集的RestTemplate
     * @return
     */
    @LoadBalanced //代表启动Ribbon,开启负载均衡机制
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("utf-8")));
        return restTemplate;

    }

    //开启http://localhost:9102/actuator/hystrix.stream 监控页面，
//    @Bean
//    public ServletRegistrationBean hystrixMetricsStreamServlet() {
//        ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
//        registration.addUrlMappings("/actuator/hystrix.stream");
//        return registration;
//    }
}
