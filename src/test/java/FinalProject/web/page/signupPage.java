package FinalProject.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class signupPage extends basePage{

    private final By usernameFieldSignup = By.id("sign-username");
    private final By passwordFieldSignup = By.id("sign-password");
    private final By signupButton = By.cssSelector("#signInModal .btn-primary");

    public signupPage(WebDriver driver) {
        super(driver);
    }

    public void inputUsernameSignup(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldSignup));
        enterText(usernameFieldSignup, username);
    }

    public void inputPasswordSignUp(String password) {
        enterText(passwordFieldSignup, password);
    }

    public void clickSignupButton() {
        clickElement(signupButton);
    }
}
