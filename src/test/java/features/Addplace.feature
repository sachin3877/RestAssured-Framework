Feature: Adding the place through APi

  @s1
  Scenario Outline: verify if place is being Succesfully added using AddPlaceApi
    Given Add place payload '<name>' '<address>''<language>'
    When user call "addPlaceAPI" with the "post" request
    Then the api call got succes with status code 200
    And "status" in the response body is "OK"
    And "scope" in the response body is "APP"
    And verify place_Id creadted maps to '<name>' using 'getplaceAPI'

    Examples: 
      | name   | address   | language |
      | mysuru | cross sea | kannada  |

  # | narasipura | sea cross      | kannada  |
  # | bangalore  | cross sea walk | kannada  |
 
  @s2
  Scenario: verify if delete place functionality is working
    Given Delete Place Payload
    When user call "deletePlaceAPI" with the "post" request
    Then the api call got succes with status code 200
    And "status" in the response body is "OK"
