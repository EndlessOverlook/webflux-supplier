package endless.overlook.webfluxsupplier.webflux;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Description:<b></b>
 *
 * @author LKL
 * @since 1/5/21 9:55 PM
 **/
@Component
public class HelloHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters
                        .fromValue("Hello, I'm a webflux supplier!"));
    }

}
