package utilities;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
	
	private static ObjectMapper mapper;
	
	static {
		mapper = new ObjectMapper(); 
	}
	
	//Javayi objectini json formatina ceviren method ==>Serialization
	public static String convertJavaToJson(Object object) {
		String jsonResult = "";	
		
		try {
			jsonResult=	mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			System.out.println("Java objesini json a cevirirken exeption olustu" + e.getMessage());		
		} catch (JsonMappingException e) {
			System.out.println("Java objesini json a cevirirken exeption olustu" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Java objesini json a cevirirken exeption olustu" + e.getMessage());
		}
       return jsonResult;
	}
	
	//Json formatindaki  data java objectine  ceviren method ==>De-Serialization
	public static <T> T  convertJsonToJava(String json, Class<T> cls) {
		
		T  javaResult= null;
		
		try {
			javaResult = mapper.readValue(json, cls);
		} catch (JsonParseException e) {
			System.out.println("json i java ya cevirirken exeption olustu" + e.getMessage());
		} catch (JsonMappingException e) {
			System.out.println("json i java ya cevirirken exeption olustu" + e.getMessage());
		} catch (IOException e) {
			System.out.println("json i java ya cevirirken exeption olustu" + e.getMessage());
		}
		
		return javaResult;
		
	}

}
