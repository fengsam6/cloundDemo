package com.feng.apigateway.fileter;

import com.alibaba.fastjson.JSON;
import com.feng.apigateway.util.JWTUtil;
import com.feng.common.entity.ResponseResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class GatewayFilter implements GlobalFilter, Ordered {
    /**
     * JTW的加密算法SigningKey
     */
    private static final String SECRET = "jwtSecret";
    /**
     * 该JWT的签发者,是否使用是可选的(可以使用项目名称或者作者名称之类)
     */
    private static final String ISS = "authTom";

    //在里面写过滤器的逻辑
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("进入了过滤器");
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        System.out.print(request.getURI().toString());
        if (isAllowAccess(request.getURI())) {
            return chain.filter(exchange);
        }
        String token = request.getHeaders().getFirst("token");

        if (StringUtils.isBlank(token)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return getVoidMono(response, ResponseResult.fail("token不能为空"));
        }


        try {
            JWTUtil.verifyToken(ISS, token, SECRET);
        } catch (Exception ex) {
            return getVoidMono(response, ResponseResult.fail("token无效"));
        }

        return chain.filter(exchange);
    }

    private boolean isAllowAccess(URI uri) {
        String url = uri.toString();
        if (url != null && url.endsWith("/v2/api-docs")) {
            return true;
        }
        return false;
    }

    //过滤器的优先级，数值越小，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }


    private Mono<Void> getVoidMono(ServerHttpResponse serverHttpResponse, ResponseResult responseResult) {
        serverHttpResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        DataBuffer dataBuffer = serverHttpResponse.bufferFactory().wrap(JSON.toJSONString(responseResult).getBytes());
        return serverHttpResponse.writeWith(Flux.just(dataBuffer));
    }

}
