package FinalProject.web.webstepdef;

import FinalProject.web.page.basePage;
import FinalProject.web.webbase.webDriver;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class categoryStepdef {

    private final WebDriver driver = webDriver.getDriver();
    private final basePage basePage = new basePage(driver);

    @And("user should see product {string}")
    public void userShouldSeeProduct(String productName) {
        boolean isVisible = basePage.isElementVisible(By.linkText(productName));
        Assertions.assertTrue(isVisible, "Product '" + productName + "' is not in this category ");
    }
}
