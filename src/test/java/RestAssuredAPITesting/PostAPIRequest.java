package RestAssuredAPITesting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostAPIRequest {
	JSONObject request=new JSONObject();
	@SuppressWarnings("unchecked")
	@Test
	public void TC1_PostMethod_ValidCredentials()
	{

		
		try {
			
			request.put("email", "eve.holt@reqres.in");
			request.put("password", "cityslicka");
			System.out.println(request.toJSONString());
			
			given().
			    header("Authorization","Bearer 123").
			    contentType(ContentType.JSON).
			    body(request.toJSONString()).relaxedHTTPSValidation().
			when().
			    post("https://reqres.in/api/login").
			then().
			assertThat().statusCode(200).
			assertThat().statusLine("HTTP/1.1 200 OK").
			log().all();
			
		
		
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked") 

	@Test 

		public void TC2_PostMethod_EmptyEmail() 

		{ 

		try { 

			//JSONObject request=new JSONObject(); 

			request.put("email", ""); 

			request.put("password", "cityslicka"); 

			System.out.println(request.toJSONString()); 

			 given().contentType(ContentType.JSON).body(request.toJSONString()).relaxedHTTPSValidation(). 

			when().post("https://reqres.in/api/login").
			then(). 

			  assertThat().statusCode(400). 

			  assertThat().statusLine("HTTP/1.1 400 Bad Request"). 

			  assertThat().body("error",equalTo("Missing email or username")).
			 

			  log().all(); 

			 

		 

		 

		} catch (Exception e) { 

		 

			System.out.println(e.getMessage()); 

			e.printStackTrace(); 

		} 

	} 

	@SuppressWarnings("unchecked") 

	@Test 

	public void TC3_PostMethod_EmptyPassword() 

	{ 

	try { 

		//JSONObject request=new JSONObject(); 

		request.put("email", "eve.holt@reqres.in"); 

		request.put("password", ""); 

		System.out.println(request.toJSONString()); 

		 

		 given(). 

		    contentType(ContentType.JSON). 

		    body(request.toJSONString()).relaxedHTTPSValidation(). 

		when(). 

		    post("https://reqres.in/api/login"). 

		then(). 

		  assertThat().statusCode(400). 

		  assertThat().statusLine("HTTP/1.1 400 Bad Request"). 

		  assertThat().body("error", equalTo("Missing password")). 

		  log().all(); 

		 

	  

	  

	} catch (Exception e) { 

		 

		System.out.println(e.getMessage()); 

		e.printStackTrace(); 

	} 

	} 

	@SuppressWarnings("unchecked") 

	@Test 

	public void TC4_PostMethod_EmptyPayload() 

	{ 

	try { 

		//JSONObject request=new JSONObject(); 

		request.put("email", ""); 

		request.put("password", ""); 

		System.out.println(request.toJSONString()); 

		 

		 given(). 

		    contentType(ContentType.JSON). 

		    body(request.toJSONString()).relaxedHTTPSValidation(). 

		when(). 

		    post("https://reqres.in/api/login"). 

		then(). 

		  assertThat().statusCode(400). 

		  assertThat().statusLine("HTTP/1.1 400 Bad Request").
		  
		  assertThat().body("error", equalTo("Missing email or username")).

		log().all(); 

		 }
	catch (Exception e) { 

		 System.out.println(e.getMessage()); 

		e.printStackTrace(); 

	} 

	}}
	
	
	


