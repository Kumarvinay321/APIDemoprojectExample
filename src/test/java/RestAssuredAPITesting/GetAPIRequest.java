package RestAssuredAPITesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class GetAPIRequest {
	@Test
	public void GetMethodRequests()
	{
		try {
	System.out.println("a");
			given().
			    param("query","new york").
			    param("locale","en_US").
			    param("currency","USD").
			    header("X-RapidAPI-Host","hotels4.p.rapidapi.com").
			    header("X-RapidAPI-Key","('Subscribe To Test' using your login to get the key - https://rapidapi.com/apidojo/api/hotels4/)").relaxedHTTPSValidation().
			when().get("https://hotels4.p.rapidapi.com/locations/v2/search").
			then().
			assertThat().statusCode(403).
			assertThat().statusLine("HTTP/1.1 403 Forbidden").
			assertThat().body("message",equalTo("You are not subscribed to this API.")).
			log().all();
			
		
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
