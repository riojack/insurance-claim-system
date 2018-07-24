package org.insu.claim;

import java.util.ArrayList;
import java.util.List;

public class ClaimService {
    public List<String> saveClaim(Claim claim) {
        List<String> validations = new ArrayList<>();

        if (claim.getClaimId() == null) {
            validations.add("Claim does not have a claim id.");
        }

        return validations;
    }
}
