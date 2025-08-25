package FinalProject.web.webstepdef;

import FinalProject.web.page.loginPage;
import FinalProject.web.page.signupPage;
import FinalProject.web.webbase.webDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

public class signupStepdef {

    private final WebDriver driver = webDriver.getDriver();
    private final loginPage loginPage = new loginPage(driver);
    private final signupPage signupPage = new signupPage(driver);


    @Given("user is on the Demoblaze home page")
    public void userIsOnTheDemoblazeHomePage() {
    }

    @When("user click Sign Up")
    public void userClickSignUp() {
        loginPage.clickSignUpLink();
    }

    @And("user enter new username {string} and password {string}")
    public void userEnterNewUsernameAndPassword(String username, String password) {
        String newUsername = username + UUID.randomUUID().toString().substring(0, 5);
        signupPage.inputUsernameSignup(newUsername);
        signupPage.inputPasswordSignUp(password);
    }

    @And("user click Sign up button")
    public void userClickSignUpButton() {
        signupPage.clickSignupButton();
    }

    @Then("user should see notif message {string}")
    public void userShouldSeeNotifMessage(String expectedMessage) {
        String alertText = signupPage.acceptAlert();
        Assertions.assertEquals(expectedMessage, alertText);
    }
}
