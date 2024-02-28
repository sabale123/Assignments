Feature: Post API

  Background:
    * url 'https://restful-booker.herokuapp.com'

    * def requestPayload =
    """
{
    "username" : "admin",
    "password" : "password123"
}


    """

  Scenario: Post API
    Given path '/auth'
    And request requestPayload
    And header Content-Type = 'application/json'
    When method post
    Then status 200






