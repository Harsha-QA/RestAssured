package CurrentWeatherData;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.response.Response;


public class GetCurrentWeatherByCityName {
	
	String APIKey = "7fe67bf08c80ded756e598d6f8fedaea";
	String CityName = "Bangalore";
	

	@Test
	void ByCityName() {
		
		Response responseData =  given().queryParam("q", CityName).queryParam("appid", APIKey)
				.when().get("http://api.openweathermap.org/data/2.5/weather");
				//.then().log().all().statusCode(200);
		
		System.out.println(responseData.asPrettyString());
		
		
		
		float temp = responseData.getBody().path("main.temp");
		System.out.println();
		
		if(temp>250 && temp <350)
		{
			System.out.println(temp+" "+"The temperature is within the specified range");
			
		}
		else
			throw new ArithmeticException("Out of specified range");
	}
		
		
				

}


