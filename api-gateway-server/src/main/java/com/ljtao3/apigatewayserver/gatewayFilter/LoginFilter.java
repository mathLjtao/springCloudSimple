package com.ljtao3.apigatewayserver.gatewayFilter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ljtao3 on 2020/3/30
 * 自定义一个全局过滤器
 */
@Component
public class LoginFilter implements GlobalFilter, Ordered {
    /*
    执行过滤器中的业务逻辑
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("access-token");
        if(token==null){
            System.out.println("没有token！！");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /*
    指定过滤器的执行顺序，返回值越小，执行优先级越高
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
