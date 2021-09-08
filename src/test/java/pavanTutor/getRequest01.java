package pavanTutor;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getRequest01 {

	@Test
	public void getweatherDetails()
	{
		 //Specify base URI
		RestAssured.baseURI ="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Request object
		Response resp = httprequest.request(Method.GET,"/Bangalore");
		
		String respbody = resp.getBody().asString();
		System.out.println("Response body is: "+respbody);
		
		//status code verification
		int statuscode = resp.getStatusCode();
		System.out.println("status code is "+ statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//verify success line
		String statusLine =  resp.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
		JsonPath jsonpath = resp.jsonPath(); //this captures the complete JSON path and stores that in the jsonpath object
		
		System.out.println(jsonpath.get("City")); //returns value of the city variable in the response body
		System.out.println(jsonpath.get("Temperature"));
		System.out.println(jsonpath.get("Humidity"));
		System.out.println(jsonpath.get("WindSpeed"));
		
		Assert.assertEquals(jsonpath.get("WindSpeed"), "something");
	}
}
