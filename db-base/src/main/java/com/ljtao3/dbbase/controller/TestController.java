package com.ljtao3.dbbase.controller;

import com.ljtao3.dbbase.dao.master.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljtao3 on 2020/3/16
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserDao userDao;
    //test db connection
    @GetMapping("/fun1")
    public String fun1(){
        return userDao.findByName("").toString();
    }
}
