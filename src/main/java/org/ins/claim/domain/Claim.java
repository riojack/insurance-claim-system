package org.ins.claim.domain;

public class Claim {
    private final String claimId;
    private final long filingTimestamp;
    private final String policyholderId;
    private final String claimCategory;

    public Claim(String claimId, long filingTimestamp, String policyholder, String claimCategory) {
        this.claimId = claimId;
        this.filingTimestamp = filingTimestamp;
        this.policyholderId = policyholder;
        this.claimCategory = claimCategory;
    }

    public String getClaimId() {
        return claimId;
    }

    public long getFilingTimestamp() {
        return filingTimestamp;
    }

    public String getPolicyholderId() {
        return policyholderId;
    }

    public String getClaimCategory() {
        return claimCategory;
    }
}
