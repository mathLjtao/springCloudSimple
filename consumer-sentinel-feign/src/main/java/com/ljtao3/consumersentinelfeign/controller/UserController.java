package com.ljtao3.consumersentinelfeign.controller;

import com.ljtao3.consumersentinelfeign.feign.DbbaseFeignclient;
import com.ljtao3.consumersentinelfeign.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljtao3 on 2020/3/30
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private DbbaseFeignclient dbbaseFeignclient;
    @GetMapping("/test1/{id}")
    public JsonData test1(@PathVariable("id") int id){
        return dbbaseFeignclient.test1(id);
    }
}
