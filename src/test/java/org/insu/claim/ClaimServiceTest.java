package org.insu.claim;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.UUID.randomUUID;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.joda.time.Instant.now;

public class ClaimServiceTest {
    // Save a claim
    // 1. Validate the claim
    // 2. Persist it

    private ClaimService claimService;

    @Before
    public void setUp() {
        claimService = new ClaimService();
    }

    @Test
    public void savingShouldSucceedWhenAllFieldsAreValid() {
        Claim claim = new Claim(randomUUID().toString(), now().getMillis(), randomUUID().toString(), "");

        List<String> validation = claimService.saveClaim(claim);

        assertThat(validation, hasSize(0));
    }

    @Test
    public void saveShouldFailIfTheClaimHasNoClaimId() {
        Claim claim = new Claim(null, now().getMillis(), randomUUID().toString(), "");

        List<String> validation = claimService.saveClaim(claim);

        assertThat(validation, hasSize(1));
        assertThat(validation.get(0), is(equalTo("Claim does not have a claim id.")));
    }
}
