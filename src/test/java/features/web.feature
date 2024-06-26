Feature: Web UI Automation

  @web
  Scenario: Initial Application Setup Create User A
    Given open Sendbird React UIKit URL Builder
    And user input appId "37C8DB25-8B44-435F-A528-5BA9B9965FD0."
    And user input userId "ufernandotest1111"
    And user input nickname "nfernandotest1111"
    And user click copy to create URL link
    And user go to link builder "ufernandotest1111", "nfernandotest1111"
    Then verify user success open url "nfernandotest1111"

  @web
  Scenario: Initial Application Setup Create User B
    Given open Sendbird React UIKit URL Builder
    And user input appId "37C8DB25-8B44-435F-A528-5BA9B9965FD0."
    And user input userId "ufernandotest2222"
    And user input nickname "nfernandotest2222"
    And user click copy to create URL link
    And user go to link builder "ufernandotest2222", "nfernandotest2222"
    Then verify user success open url "nfernandotest2222"

    @web
    Scenario: User A Create and Setup Group Channel with user B
      Given user go to link builder "ufernandotest1111", "nfernandotest1111"
      Then verify user success open url "nfernandotest1111"
      And create new group channel with add other user "ufernandotest2222"

      @web
      Scenario: User A send message and file to user B
        Given user go to link builder "ufernandotest1111", "nfernandotest1111"
        Then verify user success open url "nfernandotest1111"
        And create new group channel with add other user "ufernandotest2222"
        And user send text message "testtestteset"
        And user send image file
        And user send txt file

      @web
      Scenario: User B receive message and file from user A
        Given user go to link builder "ufernandotest2222", "nfernandotest2222"
        Then verify text message received
        Then verify image message received
        Then verify file message received


