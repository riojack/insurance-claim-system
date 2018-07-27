package org.insu.claim.tests;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class ClaimSavingTests implements En {
    public ClaimSavingTests() {
        Given("^the service is running$", () -> {
            throw new PendingException();
        });
        When("^the /save endpoint is POST-ed to$", () -> {
            throw new PendingException();
        });
        And("^the request body is empty$", () -> {
            throw new PendingException();
        });
        Then("^the response has a status code of (\\d+)$", (Integer expectedStatusCode) -> {
            throw new PendingException();
        });
        And("^the body content is \"([^\"]*)\"$", (String expectedBodyContent) -> {
            throw new PendingException();
        });
    }
}
