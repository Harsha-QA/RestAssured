package pavanTutor;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DatadrivenTease_PostNewEmployees {
	
	@Test(dataProvider = "empdataprovider")
	public void postNewEmployees(String name, String esal, String eage)
	{
		//specify base URI
				RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
				
				//request object
				RequestSpecification httprequest = RestAssured.given();
				
				//Request payload sending along with post request. 
		        JSONObject reqParams = new JSONObject();
				
				//Data which we are going to send to the server.
				reqParams.put("Name", name);
				reqParams.put("salary", esal);
				reqParams.put("age", eage);
				
				
				//add a header stating the request body in JSON
				httprequest.header("Content-Type", "application/json"); //content-type is header name. application/json is value in header
				httprequest.body(reqParams.toJSONString()); //attach data to the request
				
				//Response object
				Response resp = httprequest.request(Method.POST,"/create");
				
				String respbody = resp.getBody().asString();
				Assert.assertEquals(respbody.contains(name),true);
				Assert.assertEquals(respbody.contains(esal),true);
				Assert.assertEquals(respbody.contains(eage),true);

				int statuscode = resp.getStatusCode();
				Assert.assertEquals(statuscode, 200 );
	}

	@DataProvider(name="empdataprovider")
	String[][] getEmpData()
	{
		String empdata [][]= {{"abc12","3000","20"},{"xxx12","320000","31"},{"lmne21","213333","32"}};
		return empdata;
		
	}
}
