package com.ltjao3.eurekeserver02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer //注解启动一个服务注册中心提供给其他应用进行对话
@SpringBootApplication
public class EurekeServer02Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekeServer02Application.class, args);
    }

}
