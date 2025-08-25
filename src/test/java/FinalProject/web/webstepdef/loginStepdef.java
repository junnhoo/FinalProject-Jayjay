package FinalProject.web.webstepdef;

import FinalProject.web.page.loginPage;
import FinalProject.web.webbase.webDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class loginStepdef {

    private final WebDriver driver = webDriver.getDriver();
    private final loginPage loginPage = new loginPage(driver);

    @When("user clicks Login link")
    public void userClicksLoginLink() {
        loginPage.clickLoginLink();
    }

    @And("user enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        loginPage.inputLoginUsername(username);
        loginPage.inputLoginPassword(password);
    }

    @Then("user click Login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user should see message {string}")
    public void userShouldSeeMessage(String expectedMessage) {
        Assertions.assertTrue(loginPage.welcomeUser());
        String actualWelcomeMessage = loginPage.getWelcomeUserText();
        Assertions.assertEquals(expectedMessage, actualWelcomeMessage);
    }

    @Then("user should see error message {string}")
    public void userShouldSeeErrorMessage(String expectedErrorMessage) {
        String alertText = loginPage.acceptAlert();
        Assertions.assertEquals(expectedErrorMessage, alertText);
    }

}
