package com.ljtao3.consumersentinelfeign.feign;

import com.ljtao3.consumersentinelfeign.util.JsonData;
import org.springframework.stereotype.Component;

/**
 * @author ljtao3 on 2020/3/30
 */
@Component
public class DbbaseFeignclientCallBack implements DbbaseFeignclient{
    /*
    降级方法
     */
    @Override
    public JsonData test1(int id){
        return JsonData.success("触发熔断降级方法----test1");
    }
}
