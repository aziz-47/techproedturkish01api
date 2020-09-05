package techproedturkish01.techproedturkish01api;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import io.restassured.response.Response;
import utilities.JsonUtil;

public class ObjectMapperTestWithMap extends TestBase{
	@Test
   public void javaToJson() {
		HashMap<Integer,String> map = new HashMap<>();
		map.put(101, "Ali");
		map.put(102, "Can");
		map.put(103, "Remziye");
		System.out.println(map);
		
		//map java objesini json formata cevirdik
		String jsonFormatMap= JsonUtil.convertJavaToJson(map);
		System.out.println(jsonFormatMap);
	}
	
	
	@Test
	public void jsonToJava() {
		
		Response response = given().
				                  spec(spec01).
				            when().
				                  get("/booking/3");
		response.prettyPrint();
		
		//API'dan gelen json formatindaki datayi Map e cevirdim==>De serialzation
		Map<String,Object> jsonToMapApi= JsonUtil.convertJsonToJava(response.asString(), Map.class);
		System.out.println(jsonToMapApi);
		
		/*
		 * 1) API 'dan gelen Json Formatindaki datayi Map'e cevirdim
		 * 2) TestCase de bana verilen datatyi Map'e cevirecegim
		 * 3) 1.adimda  olsuturdugum Map ile 2. adim da olsuturdugum Map'teki datalari karsilastirararak 
		 * verification yapacagim
		 */
		
		Map<String,Object> jsonToMapTestCase = new HashMap<>();
		jsonToMapTestCase.put("firstname", "Jim");
		jsonToMapTestCase.put("lastname", "Jones");
		jsonToMapTestCase.put("totalprice", 764);
		jsonToMapTestCase.put("depositpaid", false);
		
		response.
				then().
				assertThat().
				statusCode(200);
		
		assertEquals(jsonToMapTestCase.get("firstname"),jsonToMapApi.get("firstname"));
		assertEquals(jsonToMapTestCase.get("lastname"),jsonToMapApi.get("lastname"));
		assertEquals(jsonToMapTestCase.get("totalprice"),jsonToMapApi.get("totalprice"));
		assertEquals(jsonToMapTestCase.get("depositpaid"),jsonToMapApi.get("depositpaid"));
	}
	
	
	
	
	
	
	

}
