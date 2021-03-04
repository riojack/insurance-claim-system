package org.ins.claim.repositories;

import org.ins.claim.domain.Claim;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface ClaimRepository extends ReactiveCrudRepository<Claim, UUID> {
}
