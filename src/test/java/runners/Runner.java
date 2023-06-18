package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        ADDING CONFIGURATIONS
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "rerun:target/failedRerun.txt"
        },
        monochrome = true,
        features = "./src/test/resources/features",//PATH OF FEATURES FOLDER
        glue = {"stepdefinitions","hooks"},//PATH OF STEPDEFINITIONS FOLDER
        dryRun = false, //dryRun = true : RUN AND GENERATES ONLY MISSING STEP DEFS
//                      dryRun=false :  RUN NORMAL. THIS IS DEFAULT VALUE
        tags = "@failed_test_case" //MARKS WHICH FEATURE FILE TO RUN
)
public class Runner {
}
