package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BlueRentalHomePage;
import pages.BlueRentalLoginPage;
import utilities.ReusableMethods;
import utilities.WaitUtils;

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
        blueRentalLoginPage.password.sendKeys(string2);
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
}
