package pavanTutor;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETRequest_Autorization {

	// In the example we can learn the authorization while login(username and password)
	public void Authorization()
	{
		RestAssured.baseURI ="https://restapi.demoqa.com/authentcation/CheckForAuthentication";
		
		//basic Authentication
		PreemptiveBasicAuthScheme authenticate = new PreemptiveBasicAuthScheme();
		authenticate.setUserName("sample@abc.com");
		authenticate.setPassword("password");
		
		RestAssured.authentication = authenticate; 
		
		
		RequestSpecification httpreq = RestAssured.given();
		
		Response response = httpreq.request(Method.GET,"/");
		
		String respBody = response.getBody().asString();
		System.out.println(respBody);
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, "something");
	}
}
