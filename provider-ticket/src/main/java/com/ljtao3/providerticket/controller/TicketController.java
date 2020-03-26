package com.ljtao3.providerticket.controller;

import com.ljtao3.providerticket.service.TicketService;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.executable.ValidateOnExecution;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;
    @Value("${spring.cloud.client.ip-address}")
    private String ip;
    @Value("${server.port}")
    private String port;
    @GetMapping("/getTicket")
    public String getTicket(){
        return ip+":"+port+",,"+ticketService.getTicket();
    }
}
