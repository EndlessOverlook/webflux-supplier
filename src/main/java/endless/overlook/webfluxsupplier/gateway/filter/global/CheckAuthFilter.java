package endless.overlook.webfluxsupplier.gateway.filter.global;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Description:<b></b>
 *
 * @author LKL
 * @since 2022/12/20 21:04
 **/
@Component
@Slf4j
@Order(-1)
public class CheckAuthFilter extends GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
            GatewayFilterChain chain) {
        // 校验请求头中的Token
        List<String> token = exchange.getRequest().getHeaders().get("token");
        log.info("token: " + token);
        if (token.isEmpty()) {
            return null;
        }
        return chain.filter(exchange);
    }
}
