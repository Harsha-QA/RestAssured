package practice;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;



import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PayloadwithCreatingObjects_complex {
	
	

	public static void main(String[] args)
	{
		 //for complex json we can use this approach
		
		JSONObject firstobject = new JSONObject(); //use json object library to create object in pom.xml
		firstobject.put("name", "morpheus");
		firstobject.put("job", "leader");
		
		JSONArray jarr = new JSONArray(); //use json Array library to create array
		jarr.put("Java");
		jarr.put("C");
		
		firstobject.put("skills", jarr); //skills is object name and passing array to the skills object
		
		JSONObject secondobject = new JSONObject();
		secondobject.put("companyName", "XYZ");
		secondobject.put("emailId", "morpheus@xyz.com");
		
		firstobject.put("details", secondobject);
		
		Response postresp = given().auth().none().header("ContentType", "application/json").contentType(ContentType.JSON)		
				
				.when().body(firstobject.toString()).log().all().
				post("https://reqres.in/api/user"); //sending post request along with the body
		
		System.out.println(postresp.asString());
		System.out.println(postresp.getStatusCode());
	}
	

}
