package techproedturkish01.techproedturkish01api;

import static org.junit.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class GetRequest03Tekrar {
	
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
	Response response=	given().
		                when().
		                     get("https://restful-booker.herokuapp.com/booking/7 ");
	
	response.prettyPrint();
	//status code bulamin 1 . yolu
	response.
	then().
	assertThat().
	statusCode(200).
	contentType("application/JSON").
	body("firstname", Matchers.equalTo("Susan")).
	body("lastname", Matchers.equalTo("Wilson")).
	body("totalprice",Matchers.equalTo(975)).
	body("depositpaid", Matchers.equalTo(false)).
	body("bookingdates.checkin", Matchers.equalTo("2018-06-20")).
	body("bookingdates.checkout", Matchers.equalTo("2018-12-25"));
	
	//tekrarli body kullnamdan nasil yapilir
	
	response.
	then().
	assertThat().
	statusCode(200).
	contentType("application/JSON").
	body("firstname", Matchers.equalTo("Susan"),
		 "lastname", Matchers.equalTo("Wilson"),
		 "totalprice",Matchers.equalTo(975),
		 "depositpaid", Matchers.equalTo(false),
		 "bookingdates.checkin", Matchers.equalTo("2018-06-20"),
		 "bookingdates.checkout", Matchers.equalTo("2018-12-25"));
	
	
	
	
	//status code bulmanin 2. yolu
	assertEquals(200, response.getStatusCode());
		
	}
	
	

}
