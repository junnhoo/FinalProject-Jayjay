package FinalProject.web.webstepdef;

import FinalProject.web.page.cartPage;
import FinalProject.web.page.homePage;
import FinalProject.web.page.placeOrder;
import FinalProject.web.webbase.webDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;


import java.util.List;
import java.util.Map;

public class checkoutStepdef {

    private final WebDriver driver = webDriver.getDriver();
    private final cartPage cartPage = new cartPage(driver);
    private final placeOrder placeOrder = new placeOrder(driver);

    @And("user clicks the Place Order button")
    public void userClicksThePlaceOrderButton() {
        cartPage.clickPlaceOrder();
    }

    @And("user fills the form order:")
    public void userFillsTheFormOrder(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = rows.get(0);
        placeOrder.inputName(data.get("Name"));
        placeOrder.inputCountry(data.get("Country"));
        placeOrder.inputCity(data.get("City"));
        placeOrder.inputCreditCard(data.get("Credit Card"));
        placeOrder.inputMonth(data.get("Month"));
        placeOrder.inputYear(data.get("Year"));
    }

    @And("user clicks the Purchase button")
    public void userClicksThePurchaseButton() {
        placeOrder.clickPurchaseButton();
    }

    @Then("user see message {string}")
    public void userSeeMessage(String expectedMessage) {
        String actualMessage = placeOrder.getSuccessMessage();
        Assertions.assertEquals(actualMessage, expectedMessage);
    }


    @And("user clicks OK button for confirmation")
    public void userClicksOKButtonForConfirmation() {
        placeOrder.clickOk();
    }
}
