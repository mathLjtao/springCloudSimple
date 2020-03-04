package com.ljtao3.consumeruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/buyTicket")
    public String buyTicket(){
        System.out.println("..");
        return restTemplate.getForObject("http://PROVIDER-TICKET/getTicket",String.class);
    }

    @GetMapping("/buyTicket2")
    public String buyTicket2(){
        System.out.println("buyTicket2");
        List<ServiceInstance> instances = discoveryClient.getInstances("PROVIDER-TICKET");
        if(!instances.isEmpty()){
            ServiceInstance si = instances.get(0);
            System.out.println(si.getHost());
            System.out.println(si.getPort());
            /*
            因为使用了启动类中 Bean(RestTemplate) 使用了@LoadBalanced，所以使用ip调用会报以下的错误
            System.out.println(restTemplate.getForObject("http://"+si.getHost()+":"+si.getPort()+"/getTicket",String.class));
            java.lang.IllegalStateException: No instances available for 192.168.99.1
             */
            //要这样写，才能调用服务
            System.out.println(restTemplate.getForObject("http://"+si.getServiceId()+"/getTicket",String.class));

        }
        return "buyTicket2";
    }
    /*
        从所有服务中选择一个（轮询）
     */
    @GetMapping("/buyTicket3")
    public String buyTicket3(){
        System.out.println(loadBalancerClient.choose("PROVIDER-TICKET").getUri().toString());
        return ("buyTicket3");
    }
}
