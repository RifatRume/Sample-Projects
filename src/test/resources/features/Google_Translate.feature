
Feature: Google_Translate


  Scenario Outline: Checking_Google_Translate_Application _Translation
    Given User login into Google Translate Application "<URL>"
    Then User should be successfully logged into the application
    And User select "source language" from the drop-down menu on the left
    Then User verify the "source language" displayed on the left side
    And User select "translation language" from the drop-down menu on the right
    Then User verify the "translation language" displayed on the right side
    When User enter the "initial text" in the input field on the left
    Then The "expected translation" should display as expected
    
    Examples:
    |URL|
    | https://translate.google.com/  |

 
  Scenario Outline: Checking_Google_Translate_Application _swap
    Given User login into Google Translate Application "<URL>"
    Then User should be successfully logged into the application
    And User select "source language" from the drop-down menu on the left
    Then User verify the "source language" displayed on the left side
    And User select "translation language" from the drop-down menu on the right
    Then User verify the "translation language" displayed on the right side
    When User enter the "initial text" in the input field on the left
    Then The "expected translation" should display as expected
    And User click swap languages button
    Then User verify the result
    
    Examples:
    |URL|
    | https://translate.google.com/  |
    
  
  Scenario Outline: Checking_Google_Translate_Application_Keyboard_Entry
    Given User login into Google Translate Application "<URL>"
    Then User should be successfully logged into the application
    And User select "source language" from the drop-down menu on the left
    Then User verify the "source language" displayed on the left side
    And User select "translation language" from the drop-down menu on the right
    Then User verify the "translation language" displayed on the right side
    When User enter the "initial text" in the input field on the left
    Then The "expected translation" should display as expected
    And User click swap languages button
    Then User verify the result
    And User cleared the input field
    Then User verify that input is empty
    And User click <select input tool> button and select <screen keyboard>
    And User enter <Hi> to input field
    Then User verify that "Hi" is displayed in the input field

    Examples:
    |URL|
    | https://translate.google.com/  |