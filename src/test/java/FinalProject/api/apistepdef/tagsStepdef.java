package FinalProject.api.apistepdef;

import FinalProject.api.apibase.apiBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class tagsStepdef {

    private Response response;

    @Given("I have access to Dummy API Tags")
    public void iHaveAccessToDummyAPITags() {
    }

    @When("I send a GET the tags")
    public void iSendAGETTheTags() {
        response = given().spec(apiBase.getRequest())
                .when()
                .get("tag");
    }

    @Then("the system tags response status code {int}")
    public void theSystemTagsResponseStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("the response should contain list of tags")
    public void theResponseShouldContainListOfTags() {
        response.then().body("data", notNullValue());
        response.then().body("data", instanceOf(java.util.List.class));
        response.then().body("data.size()", greaterThan(0));
    }
}
