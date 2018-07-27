Feature: Claim Saving
  Scenario: Basics
    Given the service is running
    When the /save endpoint is POST-ed to
    And the request body is empty
    Then the response has a status code of 400
    And the body content is "Cannot save claim. No claim provided."
