package FinalProject.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class productPage extends basePage {

    private final By buttonAddToCart = By.xpath("//a[text()='Add to cart']");
    private final By productPrice = By.cssSelector(".price-container h3");
    private final By productDesc = By.cssSelector("#myTabContent p");



    public productPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonAddToCart));
        clickElement(buttonAddToCart);
    }

    public String acceptNotif() {
        return acceptAlert();
    }

    public String getProductPrice() {
        return getElementText(productPrice);
    }

    public String getProductDesc() {
        return getElementText(productDesc);
    }
}
