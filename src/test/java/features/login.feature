Feature: Login using email and password

  Scenario: Login with valid email and password
    Given User is on MoneyControl home page
    When User hovers over login
    And clicks the Log-in button
    And Enters valid "alexander.rossiter@ibm.com" and "cwz!bwq.HFN*fbx0nwc"
    And clicks Login
    Then validate user has successfully logged in with "alexander.rossiter@ibm.com"
