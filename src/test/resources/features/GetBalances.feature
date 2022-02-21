Feature: Balance Checker
  This feature provides operations to get my balances in several ways, such as:
  - Balance in a specific currency
  - Sum of Balances in USD
  - List of Balances in their respective currencies
  - List of Balances in their respective currencies, minus fees

    # As a
    #   Developer
    # I want
    #   an endpoint to return my balances
    # so that
    #   I can see all my currencies with balance bigger than 0
    Scenario: Get all Balances
      Given A list of balances can be retrieved
      When I want to know all my balances in every currency that I have
      Then there are only balances greater than zero

    # As a
    #   Developer
    # I want
    #   an endpoint to return my total balance in USD
    # so that
    #   I can know the total amount I have
    Scenario: Get my Total Balance in USD
      Given A list of balances can be retrieved
      When I want to know the total balance amount I have,
      Then that amount needs to be converted to USD (currency)

    # As a
    #   Developer
    # I want
    #  to get my balance for specific currency
    # so that
    #   I can know the total amount I have for that currency
  Scenario Outline: Get my Balance for specific currency
    Given A list of balances can be retrieved
    When I want to know the total amount I have for a specific currency as "<currency>",
    Then I should receive the total amount I have for that currency as "<currency>"
    Examples:
      | currency |
      | BITC     |
      | DOGE     |
      | USDT     |

    # As a
    #   Developer
    # I want
    #   an endpoint to return my net balance (balance less fee)
    # so that
    #   I can see all my currencies with net balance bigger than 0
    Scenario: Get my Net Balance (Balance amount less fee)
      Given A list of balances can be retrieved
      When I want to know all my balances minus fee,
      Then there are only balances greater than zero