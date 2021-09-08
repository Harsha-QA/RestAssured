package practice;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*; 

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class PayloadinSameClass {
	
	String payload = "{\"name\": \"morpheus\",\"job\": \"leader\"}";
			
	
	
	@Test
	void test02() {
		

	Response postresp = given().auth().none().header("ContentType", "application/json").contentType(ContentType.JSON)		
	
	.when().body(payload).post("https://reqres.in/api/user"); //sending post request along with the body
	
   // .then().statusCode(201).body("name", equalTo("morpheus"));//validates the status code and body
	
	System.out.println(postresp.asString());
	System.out.println(postresp.getStatusCode());
}
}