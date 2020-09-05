package techproedturkish01.techproedturkish01api;

import static org.junit.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetRequest03 {
	/*
	Positive Scenario:
		 When I send a GET request to REST API URL 
		 https://restful-booker.herokuapp.com/booking/1  
	   And Accept type is “application/json”
	   Then 
	   HTTP Status Code should be 200
	   And Response format should be “application/JSON”
	   And first name should be “Mark”
	   And lastname should be “Brown”
	   And checkin date should be “2015-02-16”
	   And checkout date should be “2017-06-20"
   */
      
	@Test
	public void get01() {
		Response response = given().
				                accept("application/json"). 
				                when().get("https://restful-booker.herokuapp.com/booking/3");
		
		response.prettyPrint();
		
		//1. yol
		response.
		then().
		assertThat().
		statusCode(200).
		contentType("application/json").
		body("firstname", Matchers.equalTo("Mary")).
		body("lastname", Matchers.equalTo("Ericsson")).
		body("totalprice", Matchers.equalTo(619)).
		body("depositpaid", Matchers.equalTo(false)).
		body("bookingdates.checkin", Matchers.equalTo("2017-11-21")).
		body("bookingdates.checkout", Matchers.equalTo("2019-11-15")).
		body("additionalneeds", Matchers.equalTo("Breakfast"));
		
		//tekrarli body kullmadan nasil yapilir.
		response.
		then().
		assertThat().
		statusCode(200).
		contentType("application/json").
		body("firstname", Matchers.equalTo("Mary"),
				"lastname", Matchers.equalTo("Ericsson"),
				"totalprice", Matchers.equalTo(619),
				"depositpaid", Matchers.equalTo(false),
				"bookingdates.checkin", Matchers.equalTo("2017-11-21"),
				"bookingdates.checkout", Matchers.equalTo("2019-11-15"),
				"additionalneeds", Matchers.equalTo("Breakfast"));
		
		
		
		// staus cod icin 2 yol:
		assertEquals(200,response.getStatusCode());
		
		
	}


}
