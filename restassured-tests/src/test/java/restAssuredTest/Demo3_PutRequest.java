package restAssuredTest;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo3_PutRequest {
	private static HashMap<String,String> map = new HashMap<String,String>();
	
	int id = 2;
	String name="Rajesh";
	@BeforeClass
	public void setPostData()
	{
		map.put("name", name);
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		RestAssured.basePath="/users/"+id;
	}
	
	@Test
	public void updateData()
	{
		given()
		.contentType("application/json")
		.body(map)
		.when()
		.put()
		.then()
		.statusCode(200)
		.body("name", equalTo(name)).log().all();
	}
}
