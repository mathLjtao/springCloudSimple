package com.ljtao3.providerticket.controller;

import com.ljtao3.providerticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;
    @GetMapping("/getTicket")
    public String getTicket(){
        return ticketService.getTicket();

    }
}
