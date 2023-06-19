package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
    /*
    HOOKS is class that runs BEFORE or AFTER each SCENARIO or SCENARIO OUTLINE
    Why do you use?
        I use hooks class to generate the reports with screenshot
        My after method especially helpful to capture screenshot when a Scenario fails automatically
    What is in it?
        It has Before and After methods. I have reports method to capture the screenshot
     */
    @Before
    public void setUpScenario(){
//        RUNS BEFORE EACH SCENARIO
//        System.out.println("BEFORE METHODS");
    }
    @After
    public void tearDown(Scenario scenario) {
//       AFTER EACH SCENARIO
//        System.out.println("AFTER METHOD");

        if (scenario.isFailed()) {//attach the report only if a scenario fails
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
            Driver.closeDriver();
        }
    }
}

