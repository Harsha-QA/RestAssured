package practice;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import javax.sound.sampled.LineListener;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import udemyCourse.payload;

public class GetLists {
	
	@Test
	void test01()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
		//which prints complete response body - using response.prettyPrint.
		//Response is inbuilt class
		Response response=	given().log().all().queryParam("delay", "3")
				
				.when().get("api/users");
				
		int total = given().log().all().queryParam("delay", "3")
		
		.when().get("api/users").then().extract().path("total");
				
		
ArrayList<String> data = given().log().all().queryParam("delay", "3")
		
		.when().get("api/users").then().extract().path("data");
		
		
		response.prettyPrint();//wil print the response body
		
		System.out.println("the total value is "+total);
		System.out.println("The array data inside the data object "+data);// will print in string format
		
		//it will print each value from array list. if there is only one array element
		for(String insidearray : data)
		{
			System.out.println(insidearray);
		}
		
		
		
	}
	
	

}
