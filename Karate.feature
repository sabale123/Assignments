Feature: Get API

  Background:
    * url 'https://restful-booker.herokuapp.com/booking'

  Scenario: Get user

    When  method GET
    Then status 200
    * print response



