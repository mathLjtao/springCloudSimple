package com.ljtao3.consumeruser.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ljtao3.consumeruser.entity.User;
import com.ljtao3.consumeruser.feign.DbbaseProductFeignClient;
import com.ljtao3.consumeruser.util.JsonData;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DbbaseProductFeignClient dbbaseProductFeignClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/buyTicket")
    public String buyTicket(){
        System.out.println("..");
        //这里可以用服务名来调用，是Ribbon的作用
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

    /*
        从db-base项目拿出用户的信息
     */
    @GetMapping("/userInfo")
    public Map getUserInfo(String id){
        System.out.println(id);
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", id);
        Map forObject = restTemplate.getForObject("http://DB-BASE/user/userInfo?"+"id={id}", HashMap.class,params);

        if(forObject!=null && (boolean)forObject.get("ret")==true){

            return (HashMap)forObject.get("data");
        }
        else{
            return null;
        }
    }
    @GetMapping("/userInfo3")
    public Map getuserInfo2(String id,String name,Integer age){
        Map<String, Object> params = new HashMap();
        params.put("id", id);
        params.put("name",name);
        params.put("age",age);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request=new HttpEntity(JsonData.beanToString(params),headers);
        //Map forObject = restTemplate.postForObject("http://DB-BASE/user/userInfo2",request, HashMap.class);
        Map forObject = restTemplate.postForObject("http://DB-BASE/user/userInfo3",params, HashMap.class);//对面post接口的参数要设置好，。MB
        System.out.println("QNMD，参数就是传不过去");

        if(forObject!=null && (boolean)forObject.get("ret")==true){

            return (HashMap)forObject.get("data");
        }
        else{
            return null;
        }
    }
    /*
        使用feign框架调用远程微服务接口
     */
    @GetMapping("/userInfo4")
    public JsonData getUserInfo4(String id){
        System.out.println("id----------");
        JsonData userInfo = dbbaseProductFeignClient.getUserInfo(id);
        //JsonData userInfo = dbbaseProductFeignClient.getUserInfo4(id);
        return userInfo;
    }

    @GetMapping("/test1/{id}")
    public JsonData test1(@PathVariable("id") int id){
        JsonData result = dbbaseProductFeignClient.test1(id);
        return result;
    }
}
