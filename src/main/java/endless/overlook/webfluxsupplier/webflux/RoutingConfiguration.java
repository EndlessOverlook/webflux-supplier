package endless.overlook.webfluxsupplier.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Description:<b></b>
 *
 * @author LKL
 * @since 1/7/21 11:12 AM
 **/
@Configuration
public class RoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(
            HelloHandler helloHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/hello")
                        .and(RequestPredicates.contentType(MediaType.ALL)),
                helloHandler::hello);

    }
}
