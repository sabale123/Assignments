Feature: Delete Booking Details

Scenario: Delete existing user details

  Given url 'https://restful-booker.herokuapp.com/booking/3760'
  And header Content-Type = 'application/json'
  And header Accept = 'application/json'
  And header Cookie = 'token=d6572c19b5dc46d'
  And header Authorization = 'Basic YWRtaW46cGFzc3dvcmQxMjM='
  When method delete
  Then status 201