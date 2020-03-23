package com.ljtao3.dbbase.controller;

import com.ljtao3.dbbase.util.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljtao3 on 2020/3/16
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    /*
    用户登录这块，可以参考springboot-miaosha项目。
    用户登录成功后生成token，token作为key，用户信息作为value，保存在redis。并且token保存在用户cookie。
    下次用户访问链接，先从cookie中取得token，然后根据token从redis中取得user用户信息。
     */
    public JsonData doLogin(String userName, String password){
        String token="abc";
        return JsonData.success(token);
    }
    public JsonData getToken(String userName, String password){
        return doLogin(userName,password);
    }



}
