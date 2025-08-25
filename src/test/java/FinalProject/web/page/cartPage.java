package FinalProject.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class cartPage extends basePage {

    private final By placeOrderButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    private final By cartItems = By.cssSelector("#tbodyid tr");
    private final By productInCart = By.xpath(".//td[2]");
    private final By deleteProductInCart = By.xpath(".//td[4]/a");
    private final By cartLink = By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a");
    private final By navbar = By.id("navbarExample");

    public cartPage(WebDriver driver) {
        super(driver);
    }

    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItems));
        clickElement(placeOrderButton);
    }

    public boolean productInCart(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItems));
        List<WebElement> rows = driver.findElements(cartItems);
        for (WebElement row : rows) {
            String name = row.findElement(productInCart).getText();
            if (name.equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public int getItemsInCart() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartItems));
            return driver.findElements(cartItems).size();
        } catch (Exception e) {
            return 0;
        }
    }

    public void deleteProductInCart(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItems));
        List<WebElement> rows = driver.findElements(cartItems);
        for (WebElement row : rows) {
            String name = row.findElement(productInCart).getText();
            if (name.equalsIgnoreCase(productName)) {
                row.findElement(deleteProductInCart).click();
                wait.until(ExpectedConditions.stalenessOf(row));
                break;
            }
        }
    }

    public void clickCartLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(navbar));
        clickElement(cartLink);
    }
}
