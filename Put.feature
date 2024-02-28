Feature: Update a current booking

  Background:
    * url 'https://restful-booker.herokuapp.com/booking'

    * def requestPayload =
     """
{
    "firstname" : "James",
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

  Scenario:
    Given path '/:2681'
    And  request requestPayload

    And header Content-Type = 'application/json'
    And header Accept = 'application/json'
    And header Cookie = 'token=d6572c19b5dc46d'
    And header Authorization = 'Basic YWRtaW46cGFzc3dvcmQxMjM='
    When method put
    Then status 200
