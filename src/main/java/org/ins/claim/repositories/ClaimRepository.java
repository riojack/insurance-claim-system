package org.ins.claim.repositories;

import org.ins.claim.domain.Claim;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ClaimRepository extends CrudRepository<Claim, UUID> {
}
