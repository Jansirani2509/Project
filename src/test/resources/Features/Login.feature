Feature: Verifying Amazon Login Automation

  Scenario Outline: Verifying login with valid credentials
  Given User is on the amazon page
    When User login "<userName>","<password>"
    Then User should verify success message after login "Hello,Jansirani"  

    Examples: 
      | userName                | password       |
      | 7397074395 | Jansiyuvi@1502 |

      
      Scenario Outline: Verifying login with invalid credentials
    Given User is on the amazon page
    When User login "<userName>","<password>"
    Then User should verify error message after login "Your password is incorrect"

    Examples: 
      | userName                | password    |
      | 7397074395 | karthi@0901 |
      