package practice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import udemyCourse.payload;

public class ExtractJSON {
	
	@Test
	void test01()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		
		String name=	given().log().all().queryParam("key", "qaclick123")
				.queryParam("place_id","c1186b3cb52ff58b789fdfd7f6a5a0ce")
				.when().get("maps/api/place/get/json")
				.then().extract().path("LastName");
		
		System.out.println("The name is: "+name);
	}
	
	

}
