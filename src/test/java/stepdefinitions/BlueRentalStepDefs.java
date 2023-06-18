package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BlueRentalHomePage;
import pages.BlueRentalLoginPage;
import utilities.ReusableMethods;
import utilities.WaitUtils;

import java.util.List;
import java.util.Map;

public class BlueRentalStepDefs {
    BlueRentalHomePage blueRentalHomePage = new BlueRentalHomePage();
    BlueRentalLoginPage blueRentalLoginPage= new BlueRentalLoginPage();

    @Given("user clicks on home page login button")
    public void user_clicks_on_home_page_login_button() {
        blueRentalHomePage.homeLoginLink.click();
    }
    @Given("user enters {string} and {string}")
    public void user_enters_and(String string, String string2) {
        blueRentalLoginPage.userEmail.sendKeys(string);
        blueRentalLoginPage.userPass.sendKeys(string2);
        WaitUtils.waitFor(1);
    }
    @Given("user clicks on the login page login button")
    public void user_clicks_on_the_login_page_login_button() {
        blueRentalLoginPage.loginButton.click();
    }
    @Then("verify the default page is visible")
    public void verify_the_default_page_is_visible() {
//        if user id is displayed then default page is visible
        ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);
    }
    @Then("user logs out the application")
    public void userLogsOutTheApplication() {
        WaitUtils.waitFor(1);
        blueRentalHomePage.userID.click();
        WaitUtils.waitFor(1);
        blueRentalHomePage.logOut.click();
        WaitUtils.waitFor(1);
        blueRentalHomePage.OK.click();
        WaitUtils.waitFor(1);
    }
    @Given("user enters customer_email and customer_password")
    public void user_enters_customer_email_and_customer_password(io.cucumber.datatable.DataTable credentials) {
        /*
//      1. GET DATA AS LIST<STRING>
        List<String> customerData = credentials.row(1);
//        System.out.println(customerData);//[jack@gmail.com, 12345]
        blueRentalLoginPage.userEmail.sendKeys(customerData.get(0));//jack@gmail.com
        blueRentalLoginPage.userPass.sendKeys(customerData.get(1));//12345

         */

//      2. LIST<MAP<STRING,STRING>>
        List<Map<String,String>> customerData = credentials.asMaps(String.class,String.class);
        System.out.println(customerData);//[{email=jack@gmail.com, password=12345}]
        for (Map<String,String> each : customerData){
            blueRentalLoginPage.userEmail.sendKeys(each.get("email"));
            blueRentalLoginPage.userPass.sendKeys(each.get("password"));
        }

    }


}
