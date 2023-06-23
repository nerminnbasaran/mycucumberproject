@data_tables_new_user
Feature: data_tables_new_user

  Scenario: TC_02_data_new_user

    Given user on the application "https://editor.datatables.net/"
    And user clicks on the new button
    And user enters the firstname and lastname and position and startdate and salary
      | firstname | lastname | position | startdate  | salary |
      | serdar    | ortac    | QA       | 2023-06-15 | 3000   |
    And capture the screenshot
    And click on create button
    And search for the "firstname"
    Then verify the name field contains the "firstname"
