# We especially use DataTables for passing multiple data
# DataTables are similar to Scenario Outline

#     Difference between DataTables and Scenario Outline
#   In DataTables No Examples keyword
#   DataTables can be use in ANY STEP to provide data,
#   but Examples keyword can ONLY be used at the end of the scenario
#   In Scenario Outline: use Scenario Outline and Examples
#   DataTables returns DataTables object in the method, so we have to use Collections to use them in the step definitions
#   Scenario Outline returns a string in the method, so it is easier to get and use
#   DataTables are not as popular as Scenario Outline

@data_tables
Feature: data_tables

  Scenario: TC_01_customer_login_test

    Given user is navigates to "https://www.bluerentalcars.com/"
    And user clicks on home page login button
    And user enters customer_email and customer_password
      | email          | password |
      | jack@gmail.com |12345     |
    And capture the screenshot
    And user clicks on the login page login button
    Then verify the default page is visible
    Then user logs out the application
    Then close the application

#   INTERVIEW QUESTION : How do you use collections in your framework?
#   What is collections in java? -list, set,queue
#   How did you use collections in your framework?
#   I use collections when especially I need to store multiple test data. I use Collections when I try to het data from
#   Excel or DataTables. For example I store the multiple login credentials in my excel sheet and I use ExcelUtil class
#   to get the data as a List. I actually have ExcelUtil class that has Java Codes to get the data from an excel sheet.
#   And in that ExcelUtil we use collection, I can get the list of each column name or I can get the list of data in different form

#   I also use collections when I expect multiple elements. For example findElements() method returns a List of WebElement

#   When we work with multiple windows: getWindowHandles returns set of string - Set<String>

#   When I use Data Table in my cucumber framework, I use collections
#   I can store the data that comes from DataTables as List<Map<String,String>>
#   I can also store the data that comes from DataTables as List<List<String>> or just List<String>

#   I have Utils classes. In the util classes I used collection a lot. For example I have Excel Util class
#   When I get the column names of an excel sheet, I store column names in List<String>
#   When I get the data list from excel, I put data list in List<Map<String,String>>

