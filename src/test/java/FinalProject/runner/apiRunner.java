package FinalProject.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = {
                "FinalProject.api.apistepdef",
                "FinalProject.api.hooks"
        },
        tags = "@api",
        plugin = {
                "pretty",
                "html:reports/cucumber/api-cucumber-report.html",
                "json:report/cucumber/api-cucumber-report.json"
        },
        monochrome = true
)

public class apiRunner {
}
