Feature: Verfy the product service

  Scenario: client makes call to GET category
    When the client calls /getCategory
    Then the client receives status code of 200 for category
    And the client receives category with name