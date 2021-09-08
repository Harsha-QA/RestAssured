package practice;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAPIUsingPOJO {

	public static void main(String[] args) {
		
		PayloadwithPOJOClass pojo = new PayloadwithPOJOClass("morpheus", "leader", new String [] {"Java","C"}, 
				"XYZ", "morpheus@xyz.com");
		
Response postresp = given().auth().none().header("ContentType", "application/json").contentType(ContentType.JSON)		
				
				.when().body(pojo).log().all().
				post("https://reqres.in/api/user"); //sending post request along with the body

       System.out.println("*****it's pretty print*********");
       
		/* Assertion can be done on response body
		 * 1. using response.getBody.path()... or
		 * 2. using response.jsonpath.get()..
		 * objet.object object inside object
		 * object[0], object[1] ,,,,if it is array object
		 */
       
       //We can use this response body for assertion
       postresp.prettyPrint();
       
       String name = postresp.getBody().path("name");
       
       System.out.println(name);
       System.out.println(postresp.getBody().path("job"));
       System.out.println(postresp.getBody().path("skills[0]"));
       System.out.println(postresp.getBody().path("skills[1]"));
       System.out.println(postresp.getBody().path("details.companyName"));
       System.out.println(postresp.getBody().path("details.emailId"));
       
       Assert.assertEquals(postresp.getBody().path("name"), "morpheus");
       Assert.assertEquals(postresp.getBody().path("job"), "leader");
       Assert.assertEquals(postresp.getBody().path("skills[0]"), "Java");
       Assert.assertEquals(postresp.getBody().path("skills[1]"), "C");
       Assert.assertEquals(postresp.getBody().path("details.companyName"), "XYZ");
       Assert.assertEquals(postresp.getBody().path("details.emailId"), "morpheus@xyz.com");
       
       
       
       //another way of assertion using jsonpath and geth
       String assertusingjsonpath = postresp.jsonPath().get("name");
       System.out.println(assertusingjsonpath);
       System.out.println(postresp.jsonPath().get("job"));
       System.out.println(postresp.jsonPath().get("skills[0]"));
       System.out.println(postresp.jsonPath().get("skills[1]"));
       System.out.println(postresp.jsonPath().get("details.companyName"));
       System.out.println( postresp.jsonPath().get("details.emailId"));
		
		System.out.println(postresp.asString());
		System.out.println(postresp.getStatusCode());
		

	}

}
