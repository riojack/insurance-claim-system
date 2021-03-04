package org.ins.claim.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Claim {
    @Id
    @GeneratedValue
    private UUID claimId;
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

    public UUID getClaimId() {
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
