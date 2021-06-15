package apiEngine;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.AuthParams;
import pojo.PostData;

import java.io.File;


public class Endpoints {
    private static final String BASE_URL = "http://localhost:3000";
    public static String path = "/users";
    public static PostData  postData = new PostData("Yuvraj", "Singh", 130, 22);
    public static File jsonDataFile = new File("src/test/resources/payloads/user.json");

    public static RequestSpecification baseRequest(){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request  = RestAssured.given().contentType(ContentType.JSON);
        return request;
    }

    public static Response getUsers(){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
        Response response = request.get(path);
        return response;
    }

    public static Response postUsers(){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
       Response response = request.body(postData).post(Route.getUsers());
      return response;
   }

    public static Response putUser(){
       RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
        Response response = request.body(jsonDataFile).put(Route.getSpecificUser("5"));
       return response;
   }

   public static Response deleteUser(){
       RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
        Response response = request.delete(Route.getSpecificUser("6"));
        return response;
   }
}
