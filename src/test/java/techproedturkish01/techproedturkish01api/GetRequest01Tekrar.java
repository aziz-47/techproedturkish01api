package techproedturkish01.techproedturkish01api;

import org.junit.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetRequest01Tekrar {
	
	@Test
	public void getMethod01() {
		given().
		when().
		    get("https://restful-booker.herokuapp.com").
		then().
		    assertThat().
		    statusCode(200);
	}
	
	@Test
	public void getMethod02() {
	Response response =	given().
		                when().
		                get("https://restful-booker.herokuapp.com/booking");
	//response body i consola yazdirmak icin kullanacagimiz cod
	 response.prettyPrint();
	 
	 //status coud consola yazdirmak icin 
	 System.out.println("Staus code: " + response.getStatusCode());
	 
	 //status line consolda gormek icin 
	 System.out.println("Staus line: " + response.getStatusLine());
	 
	 //response bodyd dkei codlarin type ini alalim
	 System.out.println(response.getContentType());
	 
	 //headerstaki tum bilgileri alamk icin
	 System.out.println(response.getHeaders());
	 //headerstaki sadece bir datayi alamk icin
	 System.out.println(response.getHeader("Date"));
	 
	 //Assertion yapalim
	 response.
	 then().
	 assertThat().
	 statusCode(200).
	 contentType("application/json; charset=utf-8").
	 statusLine("HTTP/1.1 200 OK");
	 
	}
	

}
