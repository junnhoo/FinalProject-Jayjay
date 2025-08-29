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
        tags = "",
        plugin = {
                "pretty",
                "html:reports/api/api-cucumber-report.html",
                "json:reports/api/api-cucumber-report.json"
        },
        monochrome = true
)

public class apiRunner {
}
