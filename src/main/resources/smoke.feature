Feature: Smoke
  As a User
  I want to test all main site functionality
  So that i can be sure that site works correctly

  Scenario Outline: Check visibility of start page objects
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks footer visibility
    And User checks search bar visibility
    And User checks department menu button visibility
    And User checks change language button visibility
    And User checks account button visibility
    And User checks returns orders button visibility
    And User checks cart button visibility
    And User checks all button visibility
    When User clicks all button
    Then User checks that main menu list appears

    Examples:
      | homePage                |
      | https://www.amazon.com/ |

  Scenario Outline: Check that site language is switched
    Given User opens '<homePage>' page
    And User checks change language button visibility
    And User clicks change language button
    And User clicks language radio button button
    When User clicks submit changes button
    Then User checks that current url contains 'de' language

    Examples:
      | homePage                |
      | https://www.amazon.com/ |

  Scenario Outline: Check that prices currency is changed
    Given User opens '<homePage>' page
    And User checks change language button visibility
    And User clicks change language button
    And User clicks currency menu button
    And User clicks currency switch
    When User clicks submit changes button
    Then User checks that current url contains '<symbol>' symbol

    Examples:
      | homePage                | symbol |
      | https://www.amazon.com/ | BGN    |

  Scenario Outline: Check add item to cart
    Given User opens '<homePage>' page
    And User checks search bar visibility
    When User makes search by keyword '<keyword>'
    And User clicks on item page link
    And User clicks add to cart button
    Then User checks that amount of products in cart are '<quantityOfProducts>'

    Examples:
      | homePage                | keyword                                     | quantityOfProducts |
      | https://www.amazon.com/ | SAMSUNG Galaxy Z Fold 3 5G Factory Unlocked | 1                  |

  Scenario Outline: Check delete item from cart
    Given User opens '<homePage>' page
    And User checks search bar visibility
    When User makes search by keyword '<keyword>'
    And User clicks on item page link
    And User clicks add to cart button
    And User clicks cart button
    And User clicks delete item button
    Then User checks that empty cart '<message>' is visible

    Examples:
      | homePage                | keyword                                     | message                    |
      | https://www.amazon.com/ | SAMSUNG Galaxy Z Fold 3 5G Factory Unlocked | Your Amazon Cart is empty. |

  Scenario Outline: Check that wrong request message is displayed
    Given User opens '<homePage>' page
    And User checks search bar visibility
    When User makes search by keyword '<keyword>'
    Then User check that wrong request '<message>' message is visible

    Examples:
      | homePage                | keyword       | message                                              |
      | https://www.amazon.com/ | иииииииииииии | Try checking your spelling or use more general terms |

  Scenario Outline: User try to login with wrong e-mail
    Given User opens '<homePage>' page
    And User checks account button visibility
    And User click account button
    When User type email '<email>' to sign in bar
    Then User check that problem '<message>' message is visible

    Examples:
      | homePage                | email           | message             |
      | https://www.amazon.com/ | wrong@@mail.com | There was a problem |

  Scenario Outline: User try to register with wrong e-mail
    Given User opens '<homePage>' page
    And User checks account button visibility
    And User click account button
    And User click create account button
    When User type email '<email>' to email bar
    And User click create new account confirmation button
    Then User check that '<message>' message is visible

    Examples:
      | homePage                | email           | message                                                                              |
      | https://www.amazon.com/ | wrong@@mail.com | Wrong or Invalid email address or mobile phone number. Please correct and try again. |

  Scenario Outline: User try to login with wright credentials
    Given User opens '<homePage>' page
    And User checks account button visibility
    And User click account button
    When User type email '<email>' to sign in bar
    And User type password '<password>' to the password bar
    Then User check that greeting '<message>' message is visible

    Examples:
      | homePage                | email        | password | message           |
      | https://www.amazon.com/ | ssarvas@i.ua | qwerty55 | Hello, FinalTask5 |

  Scenario Outline: Check that item added to wish list
    Given User opens '<homePage>' page
    And User checks account button visibility
    And User click account button
    And User type email '<email>' to sign in bar
    And User type password '<password>' to the password bar
    And User checks search bar visibility
    When User makes search by keyword '<keyword>'
    And User clicks on item page link
    And User clicks on add to list button
    And User clicks on view list button
    Then User check that item '<name>' is visible in the list

    Examples:
      | homePage                | email        | password | keyword                                     | name                                                          |
      | https://www.amazon.com/ | ssarvas@i.ua | qwerty55 | SAMSUNG Galaxy Z Fold 3 5G Factory Unlocked | AMSUNG Galaxy Z Fold 3 5G Factory Unlocked Android Cell Phone |
