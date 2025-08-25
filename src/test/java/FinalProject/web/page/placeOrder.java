package FinalProject.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class placeOrder {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "card")
    private WebElement creditCardField;

    @FindBy(id = "month")
    private WebElement monthField;

    @FindBy(id = "year")
    private WebElement yearField;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseButton;

    @FindBy(xpath = "//h2[text()='Thank you for your purchase!']")
    private WebElement successMessage;

    @FindBy(xpath = "//button[text()='OK']")
    private WebElement okButton;

    public placeOrder(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void inputName(String name) {
        wait.until(ExpectedConditions.visibilityOf(nameField));
        nameField.sendKeys(name);
    }

    public void inputCountry(String country) {
        wait.until(ExpectedConditions.visibilityOf(countryField));
        countryField.sendKeys(country);
    }

    public void inputCity(String city) {
        wait.until(ExpectedConditions.visibilityOf(cityField));
        cityField.sendKeys(city);
    }

    public void inputCreditCard(String card) {
        wait.until(ExpectedConditions.visibilityOf(creditCardField));
        creditCardField.sendKeys(card);
    }

    public void inputMonth(String month) {
        wait.until(ExpectedConditions.visibilityOf(monthField));
        monthField.sendKeys(month);
    }

    public void inputYear(String year) {
        wait.until(ExpectedConditions.visibilityOf(yearField));
        yearField.sendKeys(year);
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }

    public void clickPurchaseButton() {
        purchaseButton.click();
    }

    public void clickOk() {
        wait.until(ExpectedConditions.elementToBeClickable(okButton)).click();
    }


}
