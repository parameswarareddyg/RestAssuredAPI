package restAssuredTest;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo2_PostRequest {
	private static HashMap<String,String> map = new HashMap<String,String>();
	@BeforeClass
	public void postData()
	{
		map.put("FirstName", RestAssuredUtils.getFirstName());
		map.put("LastName", RestAssuredUtils.getLastName());
		map.put("UserName",RestAssuredUtils.getUserName());
		map.put("Password", RestAssuredUtils.getPassword());
		map.put("email",RestAssuredUtils.getEmail());

		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		RestAssured.basePath="posts";
	}

	@Test
	public void testData()
	{
		given()
		.contentType("application/json")
		.body(map)
		.when()
		.post()
		.then()
		.statusCode(201)
		.body("FirstName",equalTo(map.get("FirstName")))
		.body("email", equalTo(map.get("email")));
	}

}
