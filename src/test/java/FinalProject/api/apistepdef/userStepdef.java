package FinalProject.api.apistepdef;

import FinalProject.api.apibase.apiBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class userStepdef {

    private Response response;
    private String userId;

    @Given("I have access to Dummy API")
    public void iHaveAccessToDummyAPI() {
    }

    @When("I send GET user by id ID {string}")
    public void iSendGETUserByIdID(String id) {
        response = given().spec(apiBase.getRequest()).log().all()
                .when()
                .get("user/" + id)
                .then().log().all()
                .extract().response();
        this.userId = id;
    }

    @Then("the system response status code {int}")
    public void theSystemResponseStatusCode(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @And("the system show the user detail with a matching ID")
    public void theSystemShowTheUserDetailWithAMatchingID() {
        response.then()
                .assertThat().body("id", equalTo(userId))
                .assertThat().body("firstName", notNullValue())
                .assertThat().body("lastName", notNullValue())
                .assertThat().body("email", notNullValue());
    }

    @When("I create a new user:")
    public void iCreateANewUser(io.cucumber.datatable.DataTable dataTable) {
        java.util.List<java.util.Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        java.util.Map<String, String> userData = data.get(0);

        String email = userData.get("email");
        if (!email.contains("${RANDOM}")) {
            email = email.replace("@", "." + UUID.randomUUID().toString().substring(0, 8) + "@");
        } else {
            email = email.replace("${RANDOM}", UUID.randomUUID().toString());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", userData.get("firstName"));
        jsonObject.put("lastName", userData.get("lastName"));
        jsonObject.put("email", email);

        response = given().spec(apiBase.getRequest()).log().all()
                .body(jsonObject.toString())
                .when()
                .post("user/create")
                .then().log().all()
                .extract().response();
        this.userId = response.jsonPath().getString("id");
        System.out.println("User created with ID: " + userId);

    }

    @And("And the response should indicate the user was created successfully")
    public void responseShouldIndicateTheUserWasCreatedSuccessfully() {
        response.then()
                .assertThat().body("id", notNullValue())
                .assertThat().body("firstName", notNullValue())
                .assertThat().body("lastName", notNullValue())
                .assertThat().body("email", notNullValue());
    }

    @When("I update the newly created user with:")
    public void iUpdateTheNewlyCreatedUserWith(io.cucumber.datatable.DataTable dataTable) {
        assertNotNull(userId, "User ID is NULL. Create a new user please");

        java.util.List<java.util.Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        java.util.Map<String, String> userData = data.get(0);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("firstName", userData.get("firstName"));
        jsonObject.put("lastName", userData.get("lastName"));

        response = given().spec(apiBase.getRequest()).log().all()
                .body(jsonObject.toString())
                .when()
                .put("user/" +userId)
                .then().log().all()
                .extract().response();
    }

    @And("the response should indicate the user was updated successfully")
    public void responseShouldIndicateTheUserWasUpdatedSuccessfully() {
        response.then()
                .assertThat().body("id", equalTo(userId))
                .assertThat().body("firstName", notNullValue())
                .assertThat().body("lastName", notNullValue());
    }

    @When("I delete the newly created user")
    public void iDeleteTheNewlyCreatedUser() {
        assertNotNull(userId, "No User ID. Created a new user please");

        response = given().spec(apiBase.getRequest()).log().all()
                .when()
                .delete("user/" + userId)
                .then().log().all()
                .extract().response();
    }

    @And("the response should indicate the user was deleted successfully")
    public void theResponseShouldIndicateTheUserWasDeletedSuccessfully() {
        response.then()
                .assertThat().body("id", notNullValue())
                .assertThat().body("message", containsString("Delete Successful"));
    }

    @And("the response should conform to the JSON schema {string}")
    public void theResponseShouldConformToTheJSONSchema(String schemaPath) {
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + schemaPath));
    }

    @And("the response should contain the error message {string}")
    public void theResponseShouldContainTheErrorMessage(String errorMessage) {
        response.then().assertThat().body("error", containsString(errorMessage));
    }
}
