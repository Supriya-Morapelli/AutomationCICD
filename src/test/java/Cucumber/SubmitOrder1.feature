@tag
Feature: Purchasing the order from Ecommerce Website
  I want to use this template for my feature file

  Background: 
    Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive Test of submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productname> to cart
    And Checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

    Examples: 
      | name                   | password   | productname   |
      | SupriyaReddy@gmail.com | Suppu@2001 | IPHONE 13 PRO |
