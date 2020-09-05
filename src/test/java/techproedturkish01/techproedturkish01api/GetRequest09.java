package techproedturkish01.techproedturkish01api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetRequest09 extends TestBase{
	
	@Test
	public void get01() {
		Response response = given().
				               spec(spec02).
			            	when().
				               get();
		
		response.prettyPrint();
		
		//JsonPath objesini olusturun
		
		JsonPath json= response.jsonPath();
		
		//Tum employee isimlerini consola yazdriniz
		
		System.out.println(json.getList("data.employee_name"));
		
		//Ikinci iscinin(index 1) isminin Gareet winters oldugunu verify(soft assertion ) ediniz
		// data bir list oldugundan istenilen eleman index ile ulasiriz
		
		//Hard Assertion ile yaptik halbuki verify diyor .Bu yuzden soft assertion kullnamaliyiz
		assertEquals("Isim istenilen gibi degil", "Garrett Winters", json.getString("data[1].employee_name"));//bu hard assertiondur
		
		
		/*
		 Soft assertion icin 3 adim takip edilmeldiir
		 1)soft assert clasindan bir obje (Softassert) olustur
		 2)Objeyi kullanarak assertion yap
		 3)softassert.assertAll();
		 */
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("data[1].employee_name", "Garrett Winters", "Iisim istenilen gibi degil");
		
		
		//Iscilerin arasinda Herrod Chandler var oldugunu verify ediniz
		
		softAssert.assertTrue(json.getList("data.employee_name").contains("Herrod Chandler"),"Herrod Chandler yok");
		
		
		//24 taen isci oldugunu verfy ediniz
		softAssert.assertEquals(json.getList("data.id").size(), 24,"24 isci yok");
		
		
		//7. iscinin maasinin 137500 oldugunu verfy ediniz 
		softAssert.assertEquals(json.getString("data[6].employee_salary"), "137500", "maas istenen gibi degil ");
		softAssert.assertAll();
		
		
		
		
		
		
		
		
		
		
		
	}

}
