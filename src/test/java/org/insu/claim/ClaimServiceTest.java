package org.insu.claim;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClaimServiceTest {
    @Test
    public void shouldBeAwesome() {
        assertThat(new ClaimService().getName(), equalTo("Scooby Doo"));
    }
}
