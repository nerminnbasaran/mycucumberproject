package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports",
                "json:target/json-report/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"
        },
        monochrome = true,
        features = "@target/failedRerun.txt",
        glue = {"stepdefinitions","hooks"},
        dryRun = false
)
public class FailedRunner {
}

/*
      1. HOW DO YOU RUN ONLY FAILED SCENARIOS?
        -I have rerun plugin in the runner that generates the lines for only failed scenarios
      2. IF ALL YOUR TESTS PASSED, DO YOU SEE THE ANY SCENARIO ON THE TXT.FILE?
        -No b/c rerun text file stores only failed scenario lines
      3. WHAT HAPPENS WHEN YOU TRY TO RERUN THE failedRUNNER IF THERE IS NO FAILED SCENARIOS LAST TIME?
        -No tests will run cause the text file is empty

      WHAT IS DIFFERENCE BETWEEN DATA DRIVEN AND KEYWORD DRIVEN FRAMEWORK AND HYBRID FRAMEWORK?
        DATA DRIVEN:
      - Testing the tests cases with multiple data. In Data driven testing we sent multiple data and expect them to pass.
      If sth fails, then dev fix and test with same data until all tests cases pass. Excel data, database data, xml data scenario outline data...
        KEYWORD DRIVEN:
      - The above categorization can be done and maintained with the help of Excel spread sheet:
      - Test Step : It is a very small description of the Test Step or the description of the Action going to perform on Test Object.
      - Test Object : It is the name of the Web Page object/element, like Username&Password
      - Action : It is the name of the action, which is going to perform on any Object such as click, open browser, input etc.
      - Test Data : Data can be any value which is needed by the Object to perform any action, like Username value for Username field
        HYBRID FRAMEWORK:
      - A framework that can do both Behavior Driven Testing and Data Driven Testing

      **Normally we used excel in JUnit, excel in Test NG, excel in cucumber



 */
