Feature: create book

  Scenario: Create and Get book
    Given I have book to add to library
    When I create new book
    Then Status code should be 201
    And Returned book json should be correct
    When I get created book from library
    Then Status code should be 200
    And Returned book json should be correct

  Scenario Outline: Create and get book2
    Given I have book to add to library with data below:
      | title   | author   | year   | isbn   | publisherName   | publisherCity   |
      | <title> | <author> | <year> | <isbn> | <publichername> | <publishercity> |
    When I create new book
    Then Status code should be 201
    And Returned book json should be correct
    Then I get created book from library
    Then Status code should be 200
    And Returned book json should be correct
    Examples:
      | title         | author  | year | isbn          | publichername | publishercity |
      | War and Peace | Tolstoy | 1869 | 1234567890123 | Piter          | St.Petersburg  |
      | Karlson       | Lingred | 1987 | 4567891230123 | Piter          | St.Petersburg  |
      | 1408          | King    | 1900 | 7894561230123 | Piter          | St.Petersburg  |
      | 1408          | King    | 1900 | 7894561230123 | Piter          | St.Petersburg  |
      | 1408          | King    | 1900 | 7894561230123 | Piter          | St.Petersburg  |
      | 1408          | King    | 1900 | 7894561230123 | Piter          | St.Petersburg  |
      | 1408          | King    | 1900 | 7894561230123 | Piter          | St.Petersburg  |
      | 1408          | King    | 1900 | 7894561230123 | Piter          | St.Petersburg  |