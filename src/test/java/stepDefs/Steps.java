package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import pojo.PostData;


import java.io.File;


public class Steps {

    RequestSpecification request;
    Response response;
    File jsonDataFile = new File("src/test/resources/payloads/user.json");
    String path = "/users";

    PostData postData = new PostData("AG", "PATIL", 7, 7);

    @Given("^User sets the base API request (.*)$")
    public void userSetsTheBaseAPIRequestUrl(String URL) {
        RestAssured.baseURI = URL;
        request  = RestAssured.given().contentType(ContentType.JSON).body(postData);
    }

    @When("^User sends the API requests to get all the users$")
    public void userSendsTheAPIRequestsToGetAllTheUsers() {
        response = request.get(path).then().extract().response();
        System.out.println(response.asString());
    }

    @When("^User sends the API post requests$")
    public void userSendsTheAPIPostRequests() {
        response = request.post(path).then().extract().response();
    }

    @Then("^User validates the response status is (.*)$")
    public void userValidatesTheResponseStatusIsCode(int code) {

        Assert.assertEquals(code,response.getStatusCode() );
    }

    @When("^User sends the API delete requests$")
    public void userSendsTheAPIDeleteRequests() {
        response = request.delete("users/4").then().extract().response();

    }

    @Then("^User validates the response status for delete is (.*)$")
    public void userValidatesTheResponseStatusForDeleteIsCode(int code) {
        Assert.assertEquals(code,response.getStatusCode());
    }

    @When("^User sends the API put requests$")
    public void userSendsTheAPIPutRequests() {
        response = request.put("users/7");
    }

    @Then("User validates the response status for put is (.*)$")
    public void userValidatesTheResponseStatusForPutIsCode(int code) {
        Assertions.assertEquals("AG", response.jsonPath().getString("firstName"));
        Assertions.assertEquals("PATIL", response.jsonPath().getString("lastName"));
        Assertions.assertEquals("7", response.jsonPath().getString("subjectId"));
        Assertions.assertEquals("7", response.jsonPath().getString("id"));

        Assert.assertEquals(code,response.getStatusCode());
        System.out.println(response.getBody().asString());
    }
}

