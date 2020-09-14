package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Ignore;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"StepDefinitions"},
        tags = {"@DBTesting","~@Ignore"},
        plugin = {"pretty","html:target/cucumber-html-report",
                "json:target/cucumber.json","junit:target/cucumber-reports/cucumber.xml"}
)

public class RunMain {
}
