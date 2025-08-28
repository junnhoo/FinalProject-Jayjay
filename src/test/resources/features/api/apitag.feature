Feature: Tag API DummyAPI
  @api
  Scenario: GET list of tags
    Given I have access to Dummy API Tags
    When I send a GET the tags
    Then the system tags response status code 200
    And the response should contain list of tags
