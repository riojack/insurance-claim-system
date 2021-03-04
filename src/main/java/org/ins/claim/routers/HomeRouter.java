package org.ins.claim.routers;

import org.ins.claim.handlers.HomeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class HomeRouter {
    @Bean
    public RouterFunction<ServerResponse> route(HomeHandler homeHandler) {
        return RouterFunctions.route(
                RequestPredicates
                        .GET("/")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN)),
                homeHandler::root);
    }
}
