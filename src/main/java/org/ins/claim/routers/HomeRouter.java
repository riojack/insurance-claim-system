package org.ins.claim.routers;

import org.ins.claim.handlers.HomeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class HomeRouter {
    @Bean
    public RouterFunction<ServerResponse> routes(HomeHandler homeHandler) {
        return route(
                GET("/").and(accept(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN)),
                homeHandler::root
        );
    }
}
