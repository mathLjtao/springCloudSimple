package com.ljtao3.consumersentinelfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient//开启发现服务功能
@EnableFeignClients //
public class ConsumerSentinelFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerSentinelFeignApplication.class, args);
    }

}
