@E2E
Feature: register an account

  Background:
    Given I am on the Lambdatest home page "https://ecommerce-playground.lambdatest.io/"

  @TesttorunNext
  Scenario: Register page is displayed when you click on Register link
#         Given I am on the Lambdatest home page "https://ecommerce-playground.lambdatest.io/"
    When I click on Register link from the MyAccount Menu
    Then the Register Account page is displayed


  @TesttorunNext1
  Scenario: Register an account
#    Given I am on the Lambdatest home page "https://ecommerce-playground.lambdatest.io/"
    When I click on Register link from the MyAccount Menu
    And enter First Name as "Lateef", Last Name as "Abdul", email as "abdul1@email.com", telephone as "07484848585" and password as "123456"
    And I click on the privacy policy
    And I click on Continue button on the register account page
    Then "Your Account Has Been Created!" is displayed


  @TesttorunNext12
  Scenario Outline:ine: Register accounts using scenario outline and examples
    When I click on Register link from the MyAccount Menu
    And enter "<firstName>", "<lastName>", "<email>", "<telephone>" and "<password>"
    And I click on the privacy policy
    And I click on Continue button on the register account page
    Then "Your Account Has Been Created!" is displayed
    Examples:
      | firstName | lastName | email           | telephone   | password |
      | Lateef    | Abdulsa  | abdul@tt.com    | 078484848   | 123456   |
      | Godwin    | Igoh     | igoh@tt.com     | 07848949948 | 123456   |
      | Grace     | Muhammad | muhammad@tt.com | 0784848848  | 123456   |


  @TesttorunNext13
  Scenario: Register accounts using scenario outline and examples
    When I click on Register link from the MyAccount Menu
    And enter details as follows
      | fieldNames | values           |
      | firstName  | Esther           |
      | lastName   | Adefir           |
      | email      | esther@email.com |
      | telephone  | 07837382882      |
      | password   | 12345            |
    And I click on the privacy policy
    And I click on Continue button on the register account page
    Then "Your Account Has Been Created!" is displayed


  @TesttorunNext14
  Scenario: Register accounts using scenario outline and examples
    When I click on Register link from the MyAccount Menu
    And enter the following details
      | Names           |
      | Esther           |
      | Adefir           |
      | esther@email.com |
      | 07837382882      |
      | 12345            |

    And I click on the privacy policy
    And I click on Continue button on the register account page
    Then "Your Account Has Been Created!" is displayed