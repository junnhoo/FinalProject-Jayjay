package FinalProject.web.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage extends basePage {

    private final By categoryPhones = By.linkText("Phones");
    private final By categoryLaptops = By.linkText("Laptops");
    private final By categoryMonitors = By.linkText("Monitors");


    public homePage (WebDriver driver) {
        super(driver);
    }

    public void clickCategoryPhones() {
        clickElement(categoryPhones);
    }

    public void clickCategoryLaptops() {
        clickElement(categoryLaptops);
    }

    public void clickCategoryMonitors() {
        clickElement(categoryMonitors);
    }

    public void selectProducts(String productName) {
        clickElement(By.linkText(productName));
    }
}
