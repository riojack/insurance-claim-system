package org.insu.claim;

public class Claim {
    private String claimId;
    private long filingTimestamp;
    private String policyholderId;
    private String claimCategory;

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
