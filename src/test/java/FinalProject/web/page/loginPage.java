package FinalProject.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class loginPage extends basePage {

    private final By usernameFieldLogin = By.id("loginusername");
    private final By passwordFieldLogin = By.id("loginpassword");
    private final By loginButton = By.cssSelector("#logInModal .btn-primary");
    private final By loginLink = By.id("login2");
    private final By welcomeUserLink = By.id("nameofuser");
    private final By signupLink = By.id("signin2");

    public loginPage (WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        clickElement(loginLink);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldLogin));
    }

    public void inputLoginUsername(String username) {
        enterText(usernameFieldLogin, username);
    }

    public void inputLoginPassword(String password) {
        enterText(passwordFieldLogin, password);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public String getWelcomeUserText() {
        return getElementText(welcomeUserLink);
    }

    public boolean welcomeUser() {
        return isElementVisible(welcomeUserLink);
    }

    public void clickSignUpLink() {
        clickElement(signupLink);
    }


}
