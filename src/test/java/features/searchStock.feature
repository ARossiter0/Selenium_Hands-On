Feature: Search for company stock information

  @StockInfo
  Scenario Outline: Search with full company name and record value and percentages
    Given User is on MoneyControl home page
    When User searches a company name <name>
    And Selects the first option that contains the company name <name>
    Then record company value, change, and percentage
    Examples:
    | name      |
    | Starbucks |
    | IBM       |
    | Apple     |
    | NetFlix   |