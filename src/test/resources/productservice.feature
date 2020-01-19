Feature: Verfy the product service

  Scenario: client makes call to GET product
    When the client calls /getProduct
    Then the client receives status code of 200
    And the client receives product with name