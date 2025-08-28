Feature: User API DummyAPI

  @api @user @positive
  Scenario: Get user by ID
    Given I have access to Dummy API
    When I send GET user by id ID "60d0fe4f5311236168a109d4"
    Then the system response status code 200
    And the system show the user detail with a matching ID
    And the response should conform to the JSON schema "user/GetUserSchema.json"

  @api @user @positive
  Scenario: Create, Update, Delete a user
    #Create
    Given I have access to Dummy API
    When I create a new user:
      | firstName | lastName | email                  |
      | Junhoo    | Poipoi   | junhoo.poipoi@yeiya.com|
    Then the system response status code 200
    And And the response should indicate the user was created successfully
    #Update
    When I update the newly created user with:
      | firstName      | lastName       |
      | FirstnameUpdate| LastnameUpdate |
    Then the system response status code 200
    And the response should indicate the user was updated successfully
    #Delete
    When I delete the newly created user
    Then the system response status code 200
    And the response should indicate the user was deleted successfully

  @api @user @negative
  Scenario: Get user details with an invalid ID
    Given I have access to Dummy API
    When I send GET user by id ID "invalidID123"
    Then the system response status code 404
    And the response should contain the error message "RESOURCE_NOT_FOUND"

