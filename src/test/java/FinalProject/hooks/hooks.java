package FinalProject.hooks;

import FinalProject.web.webbase.webDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class hooks {

    private final String webURL = "https://www.demoblaze.com";

    @Before("@web")
    public void setup() {
        WebDriver driver = webDriver.getDriver();
        driver.get(webURL);
    }

    @After("@web")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                WebDriver driver = webDriver.getDriver();
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            } catch (Exception e) {
                System.err.println("Failed to take screenshot: " + e.getMessage());
            }
        }
        webDriver.quitDriver();
    }

}
