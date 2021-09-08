package pavanTutor;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETRequest02 {
	
	
	@Test
	public void googleMapTest()
	{
		 //Specify base URI
		RestAssured.baseURI ="https://maps.googleapis.com";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Request object
		Response resp = httprequest.request(Method.GET,"/..................");
		
		String respbody = resp.getBody().asString();
		System.out.println("Response body is: "+respbody);
		
		//validating headers
		String headername = resp.header("Content-Type"); //capture details of content type header (of response)
		
		System.out.println("content type header is "+headername);
		Assert.assertEquals(headername, "applicaction/xml; charset=UTF-8");
		
		String headername1 = resp.header("Content-Encoding"); //capture details of content encoding header
		System.out.println("content type header is "+headername1);
		Assert.assertEquals(headername, "gzip");	
		
		//Verify all headers in the response
		Headers allHeaders = resp.headers();//captures all the headers from response.
		for(Header header : allHeaders)
		{
			System.out.println(header.getName()+"  " +header.getValue());
			
		}
		
		
		
	}
}
