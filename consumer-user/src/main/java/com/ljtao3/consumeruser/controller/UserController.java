package com.ljtao3.consumeruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/buyTicket")
    public String buyTicket(){
        return restTemplate.getForObject("http://PROVIDER-TICKET/getTicket",String.class);
    }
}
