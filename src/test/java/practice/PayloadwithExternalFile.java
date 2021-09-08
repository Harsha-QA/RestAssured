package practice;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PayloadwithExternalFile {
	
	@Test
	void test02() {
		

	Response postresp = given().auth().none().header("ContentType", "application/json").contentType(ContentType.JSON)		
	
	.when().body(new File("./payload.json")).post("https://reqres.in/api/user"); //sending post request along with the body
	
   
	
	System.out.println(postresp.asString());
	System.out.println(postresp.getStatusCode());
}

}
