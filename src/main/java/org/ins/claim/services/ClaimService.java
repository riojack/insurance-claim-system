package org.ins.claim.services;

import org.ins.claim.domain.Claim;
import org.ins.claim.repositories.ClaimRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClaimService {
    private final ClaimRepository claimRepository;

    public ClaimService(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    public List<String> saveClaim(Claim claim) {
        List<String> validations = new ArrayList<>();

        if (claim.getClaimId() == null) {
            validations.add("Claim does not have a claim id.");
        }
        if (claim.getFilingTimestamp() == 0) {
            validations.add("Claim does not have a valid filing date.");
        }
        if (claim.getPolicyholderId() == null) {
            validations.add("Claim does not have a valid policyholder id.");
        }

        if (validations.size() == 0) {
            claimRepository.save(claim);
        }

        return validations;
    }

    public Claim getAnyClaim() {
        return claimRepository.findAll().iterator().next();
    }
}
