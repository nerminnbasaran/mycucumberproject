@customer_login
Feature: customer_login
  Scenario Outline: TC_01_<PositiveTest>customer_login_test
    Given user is navigates to "https://www.bluerentalcars.com/"
    And user clicks on home page login button
    And user enters "<email>" and "<password>"
    And capture the screenshot
    And user clicks on the login page login button
    Then verify the default page is visible
    Then user logs out the application
    Then close the application

    Examples: test_data
      | email                          | password  |
      | sam.walker@bluerentalcars.com  | c!fas_art |
      | kate.brown@bluerentalcars.com  | tad1$Fas  |
      | raj.khan@bluerentalcars.com    | v7Hg_va^  |
      | pam.raymond@bluerentalcars.com | Nga^g6!   |

#NOTES:
#Scenaria Outline
#   It is used to run the same scenario with different data multiple times
#   It must be followed by an Examples keyword. Examples keyword is used to pass data
#   Scenario Outline is used for parametrizing of the feature files
#   It is used to pass test data dynamically

# Cucumber reports plugins
#   We can easily generate cucumber reports using report plugins in the runner
#   We can generate different reports such as HTML,json and xml; but the most common one is the HTML report


