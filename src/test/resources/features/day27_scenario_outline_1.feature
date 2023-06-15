@scenario_outline_1
Feature: search_feature
  Background: goes_to_google
    Given user is navigates to "https://www.google.com"

    Scenario Outline: search_scenario
#       "data" ---->>>> "<data>"
      And user search for "<data>"
      Then verify page title contains "<data>"
      Then close the application
#      Examples must be used with scneario outline
#      Examples is used to pass data
#      We use scenario outline to make the steps reusable
#      to make the code shorter and cleaner
      Examples: test data
        | data              |
        | bmw               |
        | tesla             |
        | mercedes          |
        | apple             |
        | banana            |
        | porcelain tea pot |
        | nio               |