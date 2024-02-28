Feature: Create new booking in the API

  Background:
    * url 'https://restful-booker.herokuapp.com'

    * def requestPayload =
    """
{
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}

    """

    Scenario: Create new booking
      Given path '/booking'
      And request requestPayload
      And header Content-Type = 'application/json'
      And header Accept = 'application/json'
      When method post
      Then status 200
      * print response
    3760
