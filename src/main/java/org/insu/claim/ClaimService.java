package org.insu.claim;

import java.util.ArrayList;
import java.util.List;

public class ClaimService {
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

        return validations;
    }
}
