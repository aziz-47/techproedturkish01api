package techproedturkish01.techproedturkish01api;

import org.junit.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetRequest01 {
//Rest Assured kullanarak API Testing yapacagiz	
	
	
	@Test
	public void getMethod01() {
		
		given().
		when().
			get("https://restful-booker.herokuapp.com/booking").
		then().
		    assertThat().
		    statusCode(200);
		
	}
	
	//Get ile aldigim datayi konsolda gormek istiyorum
	@Test
	public void getMethod02() {
		Response response = given().
		                    when().
		                    get("https://restful-booker.herokuapp.com/booking/8");
		
		//Response body yi consola yazdirmak icin response.prettyPrint(); kullanilir.
		response.prettyPrint();
		
		//ststus kodu consaolda goremk icin
		System.out.println("Status code : "+response.getStatusCode());
		
		//statusline'i konsolda goremk icin;
		System.out.println("Status line : " + response.getStatusLine());
		
		//Response body deki datanin content(icerik) type
		//1.Yol
		System.out.println("Content type 1.yol : "  +response.getContentType());
		//2.Yol
		System.out.println("Contet Type 2 .yol : " + response.getHeader("Content-Type"));
		
		
		
		//Headers taki bilgileri lamak icin;
		System.out.println("Haeders cod : "  + response.getHeaders());
		
		//headerstan istenen spesific bir datayi alamk
		
		System.out.println(response.getHeader("Date"));
		
		//Assertion yapalim
		
		///1) staus code 200
		//assertThat kullanirsaniz "Hard Assertion" yapiuyosunuz demktir
		//yani ilk  hatada code execution durur ve hata raporu verilir
		//ilk hatdan sonraki kodlar calsitrilmaz.
		response.
		then().
		assertThat().
		statusCode(200).
		statusLine("HTTP/1.1 200 OK").
		contentType("application/json; charset=utf-8");
		
		
		
		
		
		
		
		
	}
	
	

}
