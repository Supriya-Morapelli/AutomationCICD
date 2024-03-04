@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: LoginErrorValidations
    Given I landed on Ecommerce page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed.

    Examples: 
      | name                   | password  |
      | SupriyaReddy@gmail.com | Sppu@2001 |
