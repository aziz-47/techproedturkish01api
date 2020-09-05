package techproedturkish01.techproedturkish01api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetRequest09Tekrar extends TestBase {
	
	@Test
	public void get01() {
		Response response =  given().
				                spec(spec02).
				             when().
				                get();
		response.prettyPrint();
		
		//JsonPath objesini olusturun
		
		JsonPath json= response.jsonPath();
		
		//tum employee isimlerini consaol yazdriniz
		System.out.println(json.getList("data.employee_name"));
		
		//ikinci iscinin isminin Gerret Winters oldugunu verfy ediniz
		//bizim data list oldugu icin index alinmali yani idex 1 alacagiz
		//bizim bu codumuz hard assertion dur.Hard assertion ile yaptik. halbu ki soruda verfy diyor bu yuzden
		//soft assertion kullanmaliyiz
		assertEquals("Isim istenen gibi degil","Garrett Winters", json.getString("data[1].employee_name"));
		//burdaki assertEqulas junitten geliyor ve mesaji en basa yaziyor 
		
		
		
		
		/*
		 Sof assertion icin 3 adim takip edilmalidr
		 1)softAssert clasiindan bir obje (softAssert)olustur 
		 2)objeyi kullanarak assertion  yap 
		 3)softAssert.assertAll();
		 bu 3 adimdan sonra 3.adim olmazsa surekli yesil aliriz
		 */
		
		SoftAssert  softAssert = new SoftAssert();// testNg den gedligi icin ordan import ediyoruz
		softAssert.assertEquals(json.getString("data[1].employee_name"), "Garrett Winters","Isim istenilen gibi degil");
	    softAssert.assertAll();	
	    //burdaki assertEquals da testNG den geliyor ve mesaji en saga yani en son ayaziyor 
	    
	    //iscilerin arasinda Herrod Chandler in var oldugunu verfy ediniz
	    
	    softAssert.assertTrue(json.getList("data.employee_name").contains("Herrod Chandler"),"Herrod Chandler yok");
	    softAssert.assertAll();
	    
	    //24 iscinin oldugunu verfy ediniz
	    softAssert.assertEquals(json.getList("data.id").size(),24, "24 isici yok");
	    softAssert.assertAll();
	    
	    // 7. iscinin maasinin 137500 oldugunu verify eediniz
	    softAssert.assertEquals(json.getString("data[6].employee_salary"), "137500", "boyle bir maas yok");
	    softAssert.assertAll();
	    
	    
	    
	    
	    
	}

}
