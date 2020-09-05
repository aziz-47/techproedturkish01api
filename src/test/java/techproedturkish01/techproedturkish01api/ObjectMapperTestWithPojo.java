package techproedturkish01.techproedturkish01api;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.response.Response;
import utilities.JsonUtil;

public class ObjectMapperTestWithPojo extends TestBase {
	
	@Test
	public void javaToJson() {
		
		BookingDates bookingDates = new BookingDates("2020-11-03", "2020-11-05");
		System.out.println(bookingDates);
		
		//bookingDates java objesini json formata cevirdik==>serialzization
		String jsonFromPojo= JsonUtil.convertJavaToJson(bookingDates);
		System.out.println(jsonFromPojo);
	}
	
	@Test
	public void jsonToPojo() {
		Response response = given().
                              spec(spec01).
                             when().
                          get("/booking/3");
      response.prettyPrint();
      
      //API 'dan gelen Json datayi pojo classa cevirdik
     Booking jsonToPojoApi= JsonUtil.convertJsonToJava(response.asString(), Booking.class);
     System.out.println(jsonToPojoApi);
     
     //testCase de verilen json formatidnaki dtaayi pojo objesine cevirkdik
     BookingDates bookingDates= new BookingDates("2020-07-26","2020-08-21");
     Booking booking= new Booking("Susan","Jones",277,true, bookingDates,"Breakfast");
     
     
     response.
		     then().
		     assertThat().
		     statusCode(200);
     
     assertEquals(booking.getBookingdates().getCheckin(),jsonToPojoApi.getBookingdates().getCheckin());
     assertEquals(booking.getBookingdates().getCheckout(),jsonToPojoApi.getBookingdates().getCheckout());
     
      
      
	}

}
