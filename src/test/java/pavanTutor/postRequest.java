package pavanTutor;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postRequest {
	
	@Test
	void Registerput() 
	{
		//specify base URI
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		
		//request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Request payload sending along with post request. 
        JSONObject reqParams = new JSONObject();
		
		//Data which we are going to send to the server.
		reqParams.put("FirstName", "john");
		reqParams.put("LastName", "Cena");
		reqParams.put("UserName", "johney");
		reqParams.put("Password", "john**");
		reqParams.put("Email", "john@gmail.com");
		
		httprequest.header("Content-Type", "application/json"); //content-type is header name. application/json is value in header
		httprequest.body(reqParams.toJSONString()); //attach data to the request
		
		//Response object
		Response resp = httprequest.request(Method.POST,"/register");
		
		
		
		//Print response in console window
		String respbody = resp.getBody().asString();
		System.out.println("Response body is: "+respbody);
		
		//status code verification
		int statuscode = resp.getStatusCode();
		System.out.println("status code is "+ statuscode);
		Assert.assertEquals(statuscode, 200);
		
		//verify success code
		String successcode = resp.jsonPath().get("Success code");
		Assert.assertEquals(successcode, "OPERATION_SUCCESS");
	}


	}

