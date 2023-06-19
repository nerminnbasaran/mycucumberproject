package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.BlueRentalHomePage;
import pages.BlueRentalLoginPage;
import utilities.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelStepDefs {
    BlueRentalLoginPage blueRentalLoginPage;
    BlueRentalHomePage blueRentalHomePage;
    ExcelUtils excelUtils;//Used to call Excel Utils methods
    List<Map<String,String>> dataList;//Data will be coming as List of Map and we will store them in this object

    @Given("user tries to login as {string}")
    public void user_tries_to_login_as(String sheet) {

        String path = "./src/test/resources/testdata/mysmoketestdata.xlsx";
//        String sheetName = "customer_info";
        String sheetName = sheet;// we make sheetname more reusable
        excelUtils = new ExcelUtils(path,sheetName);//calling constructor
        dataList = excelUtils.getDataList();//getDataList returns all the data in that sheet

        for(Map<String,String> eachData : dataList) {
            Driver.getDriver().get(ConfigReader.getProperty("br_url"));
            blueRentalHomePage = new BlueRentalHomePage();
            blueRentalLoginPage = new BlueRentalLoginPage();
            WaitUtils.waitFor(1);
            blueRentalHomePage.homeLoginLink.click();
            WaitUtils.waitFor(1);
            blueRentalLoginPage.userEmail.sendKeys(eachData.get("username"));//WE GET THE DATA FROM EXCEL SHEET
            WaitUtils.waitFor(1);
            blueRentalLoginPage.userPass.sendKeys(eachData.get("password"));//WE GET THE DATA FROM EXCEL SHEET
            WaitUtils.waitFor(1);
            blueRentalLoginPage.loginButton.click();
            WaitUtils.waitFor(1);
            ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);
            WaitUtils.waitFor(1);

            try {
                MediaUtils.takeScreenshotOfTheEntirePage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            WaitUtils.waitFor(1);

            //LOGIN IS COMPLETE NOW TIME TO LOG OUT
            blueRentalHomePage.userID.click();
            WaitUtils.waitFor(1);
            blueRentalHomePage.logOut.click();
            WaitUtils.waitFor(1);
            blueRentalHomePage.OK.click();
            WaitUtils.waitFor(1);
        }


    }
}
