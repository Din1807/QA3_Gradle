Feature: Checking prices in catalog

  Scenario Outline: Prices check
    Given opened browser
    Given page: "https://www.1a.lv/c/datortehnika-preces-birojam/portativie-datori-un-aksesuari/portativie-datori/2t6"
    When we are setting price from "<priceFrom>" to "<priceTo>"
    Then something happens

    Examples:
      | priceFrom | priceTo |
      | 200.00    | 500.00  |
      | 500.00    | 700.00  |
