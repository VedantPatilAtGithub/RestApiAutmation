//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.junit.Assert;
//
//import java.io.File;
//
//
//public class PostSteps {
//
//    RequestSpecification request;
//    Response response;
//    File jsonDataFile = new File("src/test/resources/payloads/user.json");
//    String path = "/users";
//
//    @Given("^User sets the base API request (.*)$")
//    public void userSetsTheBaseAPIRequestURL(String URL) {
//
//        RestAssured.baseURI = URL;
//        request = RestAssured.given().contentType(ContentType.JSON).body(jsonDataFile);
//    }
//
//    @When("^User sends the API post requests$")
//    public void userSendsTheAPIPostRequests() {
//       response = request.post(path).then().extract().response();
//    }
//
//    @Then("^User validates the response status is (.*)$")
//    public void userValidatesTheResponseStatusIsCode(int code) {
//        Assert.assertEquals(code,response.getStatusCode() );
//    }
//}
