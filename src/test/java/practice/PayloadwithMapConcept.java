package practice;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*; 

import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class PayloadwithMapConcept {
	
	
	
	@Test
	void test02() {
		
		//we can hash map to read the value 
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("name", "morpheus");
		map.put("job", "leader");
		

		//sending post request along with the body
	Response postresp = given().auth().none().header("ContentType", "application/json").contentType(ContentType.JSON)		
	
	.when().body(map).log().all().
	post("https://reqres.in/api/user") ;
	
   // .then().statusCode(201).body("name", equalTo("morpheus"));//validates the status code and body
	
	System.out.println(postresp.asString());
	System.out.println(postresp.getStatusCode());
}
}