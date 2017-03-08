Feature: Dates with different date formats
  This feature shows you can have different date formats, as long as you annotate the
  corresponding step definition method accordingly.

  Scenario: Determine past date
    Given today is 2011-01-20
    When I ask if Jan 19, 2011 is in the past
    Then the result should be yes

  Scenario Outline: Determine past date with examples
    Given today is <today>
    When I ask if <date> is in the past
    Then the result should be <expected>

  Examples:
    | today      | date         | expected |
    | 2011-01-21 | Jan 19, 2011 | yes      |
    | 2011-01-20 | Jan 19, 2011 | yes      |
    | 2011-01-19 | Jan 19, 2011 | no      |
