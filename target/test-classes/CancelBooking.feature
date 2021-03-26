Feature: Verifying Adaction Cancel Booking

  Scenario Outline: Verifying Adaction Cancel Booking
    Given user is on Adactin Page
    When user should enter the login "<userName>" and "<password>" and click login button
    And user should enter "<Location>","<Hotels>","<RoomType>","<NumberOfRooms>","<CheckInDate>","<CheckOutDate>","<AdultsPerRoom>" and "<ChildrenPerPerson>" and  click Search button
    And user should click Hotel button and Continue button
    And user should enter "<FirstName>","<LastName>","<BillAdds>","<CardNo>","<CardType>","<ExpDate>","<ExpYear>","<CVVNo>" and click BookNow button
    Then User should verify cancel Booking Confirmation

    Examples: 
      | userName        | password    | Location | Hotels      | RoomType | NumberOfRooms | CheckInDate | CheckOutDate | AdultsPerRoom | ChildrenPerPerson | FirstName | LastName | BillAdds | CardNo           | CardType         | ExpDate  | ExpYear | CVVNo |
      | saravanaperumal | Saravana@31 | Sydney   | Hotel Creek | Standard | 2 - Two       | 16/03/2021  | 17/03/2021   | 2 - Two       | 2 - Two           | ABC       | ASD      | ZXCV     | 1234567891234567 | American Express | February |    2012 |  1234 |

  @reg1
  Scenario Outline: Adaction cancel booking using existing order No
    Given user is on Adactin Page
    When user should enter the login "<userName>" and "<password>" and click login button
    And user should click Book Itinerary button
    And user should search order no and click cancel selected button

    Examples: 
      | userName        | password    |
      | saravanaperumal | Saravana@31 |
