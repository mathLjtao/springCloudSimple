package com.ljtao3.consumeruser.feign.hytrix;

import com.ljtao3.consumeruser.feign.DbbaseProductFeignClient;
import com.ljtao3.consumeruser.util.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author ljtao3 on 2020/3/26
 */
@Component
public class DbbaseProductFeignClientCallBack implements DbbaseProductFeignClient {

    /*
    熔断降级方法
     */
    @Override
    public JsonData getUserInfo(String id) {
        return JsonData.success("feign调用触发熔断降级方法");
    }

    @Override
    public JsonData getUserInfo4(String id) {
        return JsonData.success("feign调用触发熔断降级方法");
    }


}
