package restAssuredTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Demo4_DeleteRequest {

	@Test
	public void deleteData()
	{
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		RestAssured.basePath="/users/2";
//		Response response =
				given()
				.when()
				.delete()
				.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK").log().all().extract().response();
//		String jsonResponseAsString=response.asString();
//		//assertEquals(jsonResponseAsString.contains("HTTP/1.1 200 OK"), true);
	}
}
