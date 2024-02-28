Feature: Update a current booking with partial payload

  Background:
    * url 'https://restful-booker.herokuapp.com/booking'

    * def requestPayload =
     """
     {
    "firstname" : "James",
    "lastname" : "Brown"
}
     """

    Scenario:
      Given path '/1'
      And  request requestPayload

      And header Content-Type = 'application/json'
      And header Accept = 'application/json'
      And header Cookie = 'token=d6572c19b5dc46d'
      And header Authorization = 'Basic YWRtaW46cGFzc3dvcmQxMjM='
      When method patch
      Then status 200