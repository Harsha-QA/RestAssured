package practice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import udemyCourse.payload;

import static io.restassured.RestAssured.*; 

import static org.hamcrest.Matchers.*;


public class test1 {
	
	@Test
	void test01()
	{
		
		
			
		Response getResp = given().queryParam("page", "2").auth().none().header("ContentType", "application/json").contentType(ContentType.JSON)		
				
			.when().get("https://reqres.in/api/users");
		
		//we can also use the below code to validate - equalTo which exists in hamcrest.matchers static class 
		//.then().statusCode(200).body("page", equalTo(2), "per_page", equalTo(6));
				
		
				//we can either use prettyPrint method or log().all() to print the responses
		
		//getResp.prettyPrint();
		System.out.println(getResp.asString());
		System.out.println(getResp.getStatusCode());
		System.out.println(getResp.getTime());
			
		
	}
	
	

}
