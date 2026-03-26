package restAssuredTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo5_BasicValidation_Json {
	
	/*
	 * 1)Test Status Code
	 * 2)Log Response 
	 * 3)Verifying Single Content in Response Body
	 * 4)Verifying multiple Content in Response Body 
	 * 5)Setting Parameters & Headers
	 */
	
	//Test Status Code
	@Test(priority =1)
	public void  testStatusCode()
	{
		 when()
		 .get("https://jsonplaceholder.typicode.com/users")
		 .then()
		 .statusCode(200);
	}

	//Log Response
	@Test(priority =2)
	public void testLogResponse()
	{
		when()
		.get("https://jsonplaceholder.typicode.com/users")
		.then()
		.statusCode(200)
		.log().all();
	}
	
	//Verifying Single Content in Response Body
	@Test(priority =3)
	public void singleContentResponseBody()
	{
		when()
		.get("https://jsonplaceholder.typicode.com/users/1")
		.then()
		.statusCode(200)
		.body("address.zipcode", equalTo("92998-3874"));
	}
	
	//Verifying Multi Content in Response Body
	@Test(priority =4)
	public void multiContentResponseBody()
	{
		when()
		.get("https://jsonplaceholder.typicode.com/users")
		.then()
		.statusCode(200)
		.body("address.zipcode", hasItems("92998-3874","58804-1099"));
	}
	
	//setting parameters & headers
	@Test(priority =5)
	public void testParamsAndHeaders()
	{
		given()
		.queryParam("id", 1)
		.header("Accept", "application/json")
		.when()
		.get("https://jsonplaceholder.typicode.com/users/1")
		.then()
		.statusCode(200)
		.body("address.zipcode", equalTo("92998-3874"));
	}
	
}
