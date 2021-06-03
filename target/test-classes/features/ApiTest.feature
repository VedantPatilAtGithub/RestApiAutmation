Feature: Test Localhost API
  Scenario Outline: User is able to validate Localhost API Response
    Given User sets the base API request <URL>
    When User sends the API requests to get all the users
    Then User validates the response status is <code>
    Examples:
      |URL|code|
      |http://localhost:3000/|200|

#  Scenario Outline: User is able to post data to Localhost API
#    Given User sets the base API request <URL>
#    When User sends the API post requests
#    Then User validates the response status is <code>
#    Examples:
#      |URL|code|
#      |http://localhost:3000/|201

#  Scenario Outline: User is able to delete user from Localhost API
#    Given User sets the base API request <URL>
#    When User sends the API delete requests
#    Then User validates the response status for delete is <code>
#    Examples:
#      |URL|code|
#      |http://localhost:3000/|200|

  Scenario Outline: User is able to update user to Localhost API
    Given User sets the base API request <URL>
    When User sends the API put requests
    Then User validates the response status for put is <code>
    Examples:
      |URL|code|
      |http://localhost:3000/|200|
