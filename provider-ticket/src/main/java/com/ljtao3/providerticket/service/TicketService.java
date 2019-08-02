package com.ljtao3.providerticket.service;

import org.springframework.stereotype.Service;

@Service
public class TicketService {
    public String getTicket(){
        System.out.println("getTicket()方法被调用！");
        return "《基督山》";

    }
}
