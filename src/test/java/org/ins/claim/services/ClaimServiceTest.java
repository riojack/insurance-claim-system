package org.ins.claim.services;

import org.ins.claim.domain.Claim;
import org.ins.claim.repositories.ClaimRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.UUID.randomUUID;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.joda.time.Instant.now;
import static org.mockito.Mockito.mock;

public class ClaimServiceTest {
    // Save a claim
    // 1. Validate the claim
    // 2. Persist it

    private ClaimService claimService;

    @Before
    public void setUp() {
        ClaimRepository claimRepository = mock(ClaimRepository.class);
        claimService = new ClaimService(claimRepository);
    }

    @Test
    public void saveShouldSucceedWhenAllFieldsAreValid() {
        Claim claim = new Claim( now().getMillis(), randomUUID().toString(), "");

        List<String> validation = claimService.saveClaim(claim);

        assertThat(validation, hasSize(0));
    }

    @Test
    public void saveShouldFailIfTheClaimHasNoClaimId() {
        Claim claim = new Claim( now().getMillis(), randomUUID().toString(), "");

        List<String> validation = claimService.saveClaim(claim);

        assertThat(validation.get(0), is(equalTo("Claim does not have a claim id.")));
    }

    @Test
    public void saveShouldFailIfTheClaimHasFilingDateOfZero() {
        Claim claim = new Claim( 0, randomUUID().toString(), "");

        List<String> validation = claimService.saveClaim(claim);

        assertThat(validation.get(0), is(equalTo("Claim does not have a valid filing date.")));
    }

    @Test
    public void saveShouldFailIfTheClaimHasNoPolicyholderId() {
        Claim claim = new Claim( now().getMillis(), null, "");

        List<String> validation = claimService.saveClaim(claim);

        assertThat(validation.get(0), is(equalTo("Claim does not have a valid policyholder id.")));
    }

    @Test
    public void saveShouldAccumulateMultipleFailures() {
        Claim claim = new Claim( 0, null, "");

        List<String> validation = claimService.saveClaim(claim);

        assertThat(validation, hasItem("Claim does not have a claim id."));
        assertThat(validation, hasItem("Claim does not have a valid filing date."));
        assertThat(validation, hasItem("Claim does not have a valid policyholder id."));
    }
}
