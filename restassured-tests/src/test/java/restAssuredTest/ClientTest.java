package restAssuredTest;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ClientTest {
	
	
	private Map<String,String> map = new HashMap<>();
	@BeforeClass
	public void loadUri()
	{
		RestAssured.baseURI="https://httpbin.org/status";
	}
	
	/*
	 * When User is trying to post something but it is not properly updated post
	 * data like name is a key here in json format but it is not mentioned in double
	 * quotes "" so it will return Status code 400 Bad Request.
	 */
	@Test
	public void testClient400()
	{
		String bodyData = "{name:\"JOHN\"}";
		Response response = RestAssured.given().contentType("application/json").body(bodyData).when().post("/400");
		Assert.assertEquals(response.getStatusCode(), 400);
	}
	
	/*
	 * User is trying to access profile with by providing wrong credentials It will
	 * return status code 401 No token, expired token, or wrong credentials.
	 */
	@Test
	public void testClient401()
	{
		Response response = RestAssured.given().when().get("/401");
		Assert.assertEquals(response.getStatusCode(), 401);
	}

	@Test
	public void testClient404()
	{
		Response response = RestAssured.given().when().get("https://reqres.in/api/unknown/2333333");
		Assert.assertEquals(response.getStatusCode(), 404);
	}

	
}
