package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.EditorHWPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.WaitUtils;

import java.util.List;
import java.util.Map;

public class EditorHomeworkStepDefs {
    EditorHWPage editorHWPage = new EditorHWPage();

    @Given("user on the application {string}")
    public void user_on_the_application(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("homework"));

    }
    @Given("user clicks on the new button")
    public void user_clicks_on_the_new_button() {
        editorHWPage.newButton.click();
    }
    @Given("user enters the {string} and {string} and {string} and {string} and {string}")
    public void user_enters_the_and_and_and_and(String string, String string2, String string3, String string4, String string5) {
        WaitUtils.waitFor(2);
        editorHWPage.firstName.sendKeys(string);
        WaitUtils.waitFor(2);
        editorHWPage.lastName.sendKeys(string2);
        WaitUtils.waitFor(2);
        editorHWPage.position.sendKeys(string3);
        WaitUtils.waitFor(2);
        editorHWPage.startDate.sendKeys(string4);
        WaitUtils.waitFor(2);
        editorHWPage.salary.sendKeys(string5);
        WaitUtils.waitFor(2);
    }

    @Given("click on create button")
    public void click_on_create_button() {
        editorHWPage.createButton.click();
        WaitUtils.waitFor(2);
    }
    @Given("search for the first name {string}")
    public void search_for_the_first_name(String string) {
        editorHWPage.searchBox.sendKeys(string);
    }
    @Then("verify the name field contains the first name {string}")
    public void verify_the_name_field_contains_the_first_name(String string) {
        WaitUtils.waitFor(2);
        Assert.assertTrue(editorHWPage.nameColumn.getText().contains(string));
    }

    @And("user enters the firstname and lastname and position and startdate and salary")
    public void userEntersTheFirstnameAndLastnameAndPositionAndStartdateAndSalary(io.cucumber.datatable.DataTable credentials) {
        List<Map<String,String>> customerData = credentials.asMaps(String.class,String.class);
        for (Map<String,String> each : customerData) {
            WaitUtils.waitFor(2);
            editorHWPage.firstName.sendKeys(each.get("firstname"));
            WaitUtils.waitFor(2);
           editorHWPage.lastName.sendKeys(each.get("lastname"));
            WaitUtils.waitFor(2);
           editorHWPage.position.sendKeys(each.get("position"));
            WaitUtils.waitFor(2);
           editorHWPage.startDate.sendKeys(each.get("startdate"));
            WaitUtils.waitFor(2);
           editorHWPage.salary.sendKeys(each.get("salary"));
        }
    }
    @Given("search for the {string}")
    public void search_for_the(String string) {
        WaitUtils.waitFor(2);
        editorHWPage.searchBox.sendKeys(string);
    }
    @Then("verify the name field contains the {string}")
    public void verify_the_name_field_contains_the(String string) {
        WaitUtils.waitFor(2);
       Assert.assertTrue(editorHWPage.nameColumn.getText().contains(string));
    }


}

