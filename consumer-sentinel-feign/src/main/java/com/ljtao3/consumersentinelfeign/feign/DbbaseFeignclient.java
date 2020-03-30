package com.ljtao3.consumersentinelfeign.feign;

import com.ljtao3.consumersentinelfeign.util.JsonData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ljtao3 on 2020/3/30
 */
@FeignClient(name="DB-BASE",fallback = DbbaseFeignclientCallBack.class)
public interface DbbaseFeignclient {
    String  USER_API="/user";
    @GetMapping(USER_API+"/test1/{id}")
    JsonData test1(@PathVariable("id") int id);
}
