package restAssuredTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class Demo1_GetRequest {
//	@Test
//	public void getWheatherDetails()
//	{
//		given()
//		.when()
//		.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
//		.then()
//		.statusCode(200)
//		.statusLine("HTTP/1.1 200 OK")
//		.assertThat().body("City", equalTo("Hyderabad"));
//		
//	}
	@Test
	public void getWeatherDetails() {
	    given()
	    .when()
	    .get("https://jsonplaceholder.typicode.com/posts/1")
	    .then()
	    .statusCode(200)
	    .statusLine("HTTP/1.1 200 OK")
	    .assertThat().body("title",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));;
	}

}
