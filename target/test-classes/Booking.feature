Feature: Verifying the Adactin Hotel Booking

  @smoke
  Scenario Outline: Selecting all fields for Booking Confirmation
    Given user is on Adactin Page
    When user should enter the login "<userName>" and "<password>" and click login button
    And user should enter "<Location>","<Hotels>","<RoomType>","<NumberOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildrenPerPerson>" and  click Search button
    And user should click Hotel button and Continue button
    And user should enter "<FirstName>","<LastName>","<BillAdds>","<CardNo>","<CardType>","<ExpDate>","<ExpYear>","<CVVNo>" and click BookNow button

    Examples: 
      | userName        | password    | Location | Hotels      | RoomType | NumberOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerPerson | FirstName | LastName | BillAdds | CardNo           | CardType         | ExpDate  | ExpYear | CVVNo |
      | saravanaperumal | Saravana@31 | Sydney   | Hotel Creek | Standard | 2 - Two       | 16/03/2021  | 17/03/2021   | 2 - Two       | 2 - Two           | ABC       | ASD      | ZXCV     | 1234567891234567 | American Express | February |    2012 |  1234 |

  @smoke @reg
  Scenario Outline: Veifying Book Hotel Page without entering any fields
    Given user is on Adactin Page
    When user should enter the login "<userName>" and "<password>" and click login button
    And user should enter "<Location>","<Hotels>","<RoomType>","<NumberOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" ,"<ChildrenPerPerson>" and click Search button
    And user should click Hotel button and Continue button
    And user should enter book now button
    Then User should verify error messages

    Examples: 
      | userName        | password    | Location | Hotels      | RoomType | NumberOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerPerson |
      | saravanaperumal | Saravana@31 | Sydney   | Hotel Creek | Standard | 2 - Two       | 16/03/2021  | 17/03/2021   | 2 - Two       | 2 - Two           |
