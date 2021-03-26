Feature: Verifying Adactin Search Hotel Details

  @smoke
  Scenario Outline: Selecting all fields in the page
    Given user is on Adactin Page
    When user should enter the login "<userName>" and "<password>" and click login button
    And user should enter "<Location>","<Hotels>","<RoomType>","<NumberOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>","<ChildrenPerPerson>" and click search button
    Then user should verify the select hotel page

    Examples: 
      | userName        | password    | Location | Hotels      | RoomType | NumberOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerPerson |
      | saravanaperumal | Saravana@31 | Sydney   | Hotel Creek | Standard | 2 - Two       | 26/03/2021  | 27/03/2021   | 2 - Two       | 2 - Two           |

  @reg
  Scenario Outline: Verifying mandatory functions
    Given user is on Adactin Page
    When user should enter the login "<userName>" and "<password>" and click login button
    And user should enter "<Location>","<NumberOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and click search button
    Then user should verify the hotel page

    Examples: 
      | userName        | password    | Location | NumberOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom |
      | saravanaperumal | Saravana@31 | Sydney   | 2 - Two       | 26/03/2021  | 27/03/2021   | 2 - Two       |

  @smoke
  Scenario Outline: Verifying the checkin date and checkout date
    Given user is on Adactin Page
    When user should enter the login "<userName>" and "<password>" and click login button
    And user should enter "<CheckInDate>","<CheckOutDate>"
    Then user should verify the error message

    Examples: 
      | userName        | password    | CheckInDate | CheckOutDate |
      | saravanaperumal | Saravana@31 | 28/03/2021  | 26/03/2021   |

  @reg
  Scenario Outline: Verifying the Search Hotel Page without entering any fields
    Given user is on Adactin Page
    When user should enter the login "<userName>" and "<password>" and click login button
    Then user should verify the error messages

    Examples: 
      | userName        | password    |
      | saravanaperumal | Saravana@31 |
