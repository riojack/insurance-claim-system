package org.insu.claim;

import java.util.ArrayList;
import java.util.List;

public class ClaimService {
    public List<String> saveClaim(Claim claim) {
        List<String> validations = new ArrayList<>();

        if (claim.getClaimId() == null) {
            validations.add("Claim does not have a claim id.");
        }
        else if (claim.getFilingTimestamp() == 0) {
            validations.add("Claim does not have a valid filing date.");
        }
        else if (claim.getPolicyholderId() == null) {
            validations.add("Claim does not have a valid policyholder id.");
        }

        return validations;
    }
}
