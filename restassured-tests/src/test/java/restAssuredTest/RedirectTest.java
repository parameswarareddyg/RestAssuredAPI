package restAssuredTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RedirectTest {
	@Test
	public void testRedirect301()
	{
		Response response = RestAssured.given().redirects().follow(false).when().get("https://httpbin.org/status/301");
		Assert.assertEquals(response.statusCode(), 301,"Expected Value");
		// Validate 'Location' header (where it wants to redirect) 
		String location = response.getHeader("Location"); 
		System.out.println("Redirect Location: " + location); 
		Assert.assertNotNull(location, "Location header should be present");
		Assert.assertNotEquals(response.statusCode(), 200);
		Assert.assertNotEquals(response.statusCode(), 201);
		Assert.assertNotEquals(response.statusCode(), 204);
		Assert.assertNotEquals(response.statusCode(), 400);
		Assert.assertNotEquals(response.statusCode(), 401);
		Assert.assertNotEquals(response.statusCode(), 404);
		Assert.assertTrue(response.statusCode()>200 && response.statusCode()<400);
	}
	
	@Test
	public void testRedirect302()
	{
		Response response = RestAssured.given().redirects().follow(false).when().get("https://httpbin.org/status/302");
		Assert.assertEquals(response.statusCode(), 302,"Expected Value");
		Assert.assertNotEquals(response.statusCode(), 200);
		Assert.assertNotEquals(response.statusCode(), 201);
		Assert.assertNotEquals(response.statusCode(), 204);
		Assert.assertTrue(response.statusCode()>200 && response.statusCode()<400);
	}
	
	@Test
	public void testRedirect307()
	{
		Response response = RestAssured.given().redirects().follow(false).when().get("https://httpbin.org/status/307");
		Assert.assertEquals(response.statusCode(), 307,"Expected Value");
		Assert.assertTrue(response.statusCode()>200 && response.statusCode()<400);
	}
	
	
}
