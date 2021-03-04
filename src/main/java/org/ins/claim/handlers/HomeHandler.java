package org.ins.claim.handlers;

import org.ins.claim.domain.Claim;
import org.ins.claim.services.ClaimService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class HomeHandler {
    private final ClaimService claimService;

    public HomeHandler(ClaimService claimService) {
        this.claimService = claimService;
    }

    public Mono<ServerResponse> root(ServerRequest request) {
        Claim claim = claimService.getAnyClaim();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(claim));
    }
}
