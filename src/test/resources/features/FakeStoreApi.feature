Feature: Create, update and delete a user

  @PostUser
  Scenario: Create user successfully.
    When I consume the endpoint and I send the user information email, username, password, firstname, lastname
    Then I can validate the response service

  @PutUser
  Scenario: Update user successfully.
    When I consume the endpoint and I send the user information for updating a exists user
    Then I can validate the response service

  @DeleteUser
  Scenario: Delete user successfully.
    When I consume the endpoint and I send the parameter id for deleting a exists user
    Then I can validate the phone

