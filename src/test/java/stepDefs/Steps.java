package stepDefs;

import apiEngine.Endpoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class Steps {

    RequestSpecification request;
    Response response;

    @Given("^User sets the base API request (.*)$")
    public void userSetsTheBaseAPIRequestUrl(String URL) {
        Endpoints.baseRequest();
    }

    @When("^User sends the API requests to get all the users$")
    public void userSendsTheAPIRequestsToGetAllTheUsers() {
        response = Endpoints.getUsers().then().extract().response();
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Status message: " + response.body().asString());
    }

    @Then("^User validates the response status for get request is (.*)$")
    public void userValidatesTheResponseStatusForGetRequestIsCode(int code) {
        Assert.assertEquals(code, response.getStatusCode());
    }


    @When("^User sends the API post requests$")
    public void userSendsTheAPIPostRequests() {
        response = Endpoints.postUsers().then().extract().response();
        System.out.println(response.getBody().asString());
    }

    @Then("^User validates the response status for post is (.*)$")
    public void userValidatesTheResponseStatusIsCode(int code) {
        Assert.assertEquals(code,response.getStatusCode() );
    }

    @Then("^User validates the json schema status code(.*)$")
    public void userValidatesTheJsonSchemaStatusCode(int code) {
        Endpoints.getUsers().then().assertThat().body(matchesJsonSchemaInClasspath("schema.json")).statusCode(code);
    }

    @When("^User sends the API delete requests$")
    public void userSendsTheAPIDeleteRequests() {
        response = Endpoints.deleteUser().then().extract().response();
    }

    @Then("^User validates the response status for delete is (.*)$")
    public void userValidatesTheResponseStatusForDeleteIsCode(int code) {
        Assert.assertEquals(code,response.getStatusCode());
    }

    @When("^User sends the API put requests$")
    public void userSendsTheAPIPutRequests() {
        response = Endpoints.putUser().then().extract().response();
    }

    @Then("User validates the response status for put is (.*)$")
    public void userValidatesTheResponseStatusForPutIsCode(int code) {
        Assertions.assertEquals("shikhar", response.jsonPath().getString("firstName"));
        Assertions.assertEquals("Dhawan", response.jsonPath().getString("lastName"));
        Assertions.assertEquals("5", response.jsonPath().getString("subjectId"));
        Assertions.assertEquals("6", response.jsonPath().getString("id"));

        Assert.assertEquals(code,response.getStatusCode());
        System.out.println(response.getBody().asString());
    }

}

