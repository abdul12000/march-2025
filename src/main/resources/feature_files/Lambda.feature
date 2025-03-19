Feature: register an account

  @TesttorunNext
  Scenario: Register page is displayed when you click on Register link
    Given I am on the Lambdatest home page "https://ecommerce-playground.lambdatest.io/"
    When I click on Register link from the MyAccount Menu
    Then the Register Account page is displayed


  @TesttorunNext1
  Scenario: Register an account
    Given I am on the Lambdatest home page "https://ecommerce-playground.lambdatest.io/"
    When I click on Register link from the MyAccount Menu
    And enter First Name as "Lateef", Last Name as "Abdul", email as "abdul1@email.com", telephone as "07484848585" and password as "123456"
    And I click on the privacy policy
    And I click on Continue button on the register account page
    Then "Your Account Has Been Created!" is displayed
