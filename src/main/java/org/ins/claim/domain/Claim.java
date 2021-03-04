package org.ins.claim.domain;

import org.springframework.data.annotation.Id;

public class Claim {
    @Id
    private long claimId;
    private long filingTimestamp;
    private String policyholderId;
    private String claimCategory;

    protected Claim() {
    }

    public Claim(long filingTimestamp, String policyholderId, String claimCategory) {
        this.filingTimestamp = filingTimestamp;
        this.policyholderId = policyholderId;
        this.claimCategory = claimCategory;
    }

    public long getClaimId() {
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
