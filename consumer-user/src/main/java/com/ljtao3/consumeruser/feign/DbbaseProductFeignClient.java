package com.ljtao3.consumeruser.feign;

import com.ljtao3.consumeruser.config.FeignLogConfiguration;
import com.ljtao3.consumeruser.util.JsonData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ljtao3 on 2020/3/25
 * @FeignClient
 *  name : 服务提供者的名称
 */
@FeignClient(name="DB-BASE",configuration = FeignLogConfiguration.class)
public interface DbbaseProductFeignClient {
    public final static String  USER_API="/user";
    /*
        需要配置调用微服务的接口。
     */
    @RequestMapping(value=USER_API+"/userInfo",method = RequestMethod.GET)
    JsonData getUserInfo(@RequestParam("id") String id);

    /*
        另一种格式。
     */
    @RequestMapping(value=USER_API+"/userInfo4/{id}",method = RequestMethod.GET)
    JsonData getUserInfo4(@PathVariable("id") String id);
}
