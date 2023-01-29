package endless.overlook.webfluxsupplier.gateway.filter.global;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Description:<b></b>
 *
 * @author LKL
 * @since 2022/12/20 21:07
 **/
@Component
public class CheckIPFilter extends GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
            GatewayFilterChain chain) {
        HttpHeaders headers = exchange.getRequest().getHeaders();
        // 模拟对IP的访问限制，即不在IP白名单中就不能调用的需求
        if (getIp(headers).equals("127.0.0.1")) {
            return null;
        }
        return chain.filter(exchange);
    }

    private String getIp(HttpHeaders headers) {
        return headers.getHost().getHostName();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
