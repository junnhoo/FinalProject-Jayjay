package FinalProject.web.webstepdef;

import FinalProject.web.page.cartPage;
import FinalProject.web.page.homePage;
import FinalProject.web.page.productPage;
import FinalProject.web.webbase.webDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class cartStepdef {

    private final WebDriver driver = webDriver.getDriver();
    private final cartPage cartPage = new cartPage(driver);
    private final homePage homePage = new homePage(driver);
    private final productPage productPage = new productPage(driver);

    @Then("user clicks category {string}")
    public void userClicksCategory(String category) {
        switch (category.toLowerCase()) {
            case "phones":
                homePage.clickCategoryPhones();
                break;
            case "laptops":
                homePage.clickCategoryLaptops();
                break;
            case "monitors":
                homePage.clickCategoryMonitors();
                break;
            default:
                throw new IllegalArgumentException("Wrong Category: " + category);

        }
    }

    @And("user select product {string}")
    public void userSelectProduct(String productName) {
        homePage.selectProducts(productName);
    }

    @And("user clicks {string}")
    public void userClicks(String buttonName) {
        if ("Add to cart".equalsIgnoreCase(buttonName)) {
            productPage.clickAddToCart();
        } else {
            throw new IllegalArgumentException("No Button: " + buttonName);
        }
    }

    @Then("user should see a message {string} and accept it")
    public void userShouldSeeAMessageAndAcceptIt(String expectedMesage) {
        String alertText = productPage.acceptNotif();
        Assertions.assertEquals(expectedMesage, alertText);
    }

    @When("user click Cart link")
    public void userClickCartLink() {
        cartPage.clickCartLink();
    }

    @Then("product {string} should be in the cart")
    public void productShouldBeInTheCart(String productName) {
        Assertions.assertTrue(cartPage.productInCart(productName),
                "Product '" + productName + "'not in the cart");
    }
}
