package FinalProject.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/web",
        glue = {
                "FinalProject.web.webstepdef",
                "FinalProject.hooks"
        },
        tags = "@web",
        plugin = {
                "pretty",
                "html:reports/web/web-cucumber-report.html",
                "json:reports/web/json/web-cucumber-report.json"
        },
        monochrome = true
)
public class webRunner {
}
