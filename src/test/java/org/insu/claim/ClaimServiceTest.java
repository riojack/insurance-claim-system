package org.insu.claim;

import org.junit.Test;

import java.util.List;

import static java.util.UUID.randomUUID;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.joda.time.Instant.now;

public class ClaimServiceTest {
    // Save a claim
    // 1. Validate the claim
    // 2. Persist it

    @Test
    public void savingShouldSucceedWhenAllFieldsAreValid() {
        ClaimService claimService = new ClaimService();
        Claim claim = new Claim(randomUUID().toString(), now().getMillis(), randomUUID().toString(), "");

        List<String> validation = claimService.saveClaim(claim);

        assertThat(validation, hasSize(0));
    }
}
