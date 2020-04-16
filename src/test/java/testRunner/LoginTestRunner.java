package testRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "classpath:Login.feature",
        glue = "stepDefinitions",
        monochrome = true,
        dryRun = false,
        plugin = {"pretty",
                "html:target/cucumber-htmlreport",
                "json:target/cucumber-report.json",
                "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport.html"

        }


)
public class LoginTestRunner {
}
