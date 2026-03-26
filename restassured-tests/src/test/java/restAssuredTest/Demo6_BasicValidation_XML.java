package restAssuredTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Demo6_BasicValidation_XML {

	/*
	 * 1)Verifying Single Content in XML Response 
	 * 2)Verifying Multiple Content in XML Response 
	 * 3)Verifying all the Content in XML Response in one go
	 * 4)Find Values using XML Path in XML Response. 
	 * 5)Xpath with text() Function.
	 */
	
	@BeforeClass
	public void testData()
	{
		RestAssured.baseURI="https://www.nasa.gov";
		RestAssured.basePath="/rss/dyn/breaking_news.rss";
	}
	@Test(priority =1)
	public void testSingleContent()
	{
		when()
		.get()
		.then()
		.statusCode(200)
		.body("rss.channel.title", equalTo("NASA")).log().all();
	}
	
	@Test(priority =2)
	public void testMultipleContent()
	{
		when()
		.get()
		.then()
		.statusCode(200)
		.body("rss.channel.title", equalTo("NASA"))
		.body("rss.channel.language", equalTo("en-US"))
		.body("rss.channel.description", equalTo("Official National Aeronautics and Space Administration Website")).log().all();
	}
	
	@Test(priority =3)
	public void testMultipleContentsInOneGo() {
	    String combined = 
	        get()
	        .xmlPath()
	        .getString("rss.channel.title") +
	        get().xmlPath().getString("rss.channel.language") +
	        get().xmlPath().getString("rss.channel.description");

	    assert combined.equals("NASAen-USOfficial National Aeronautics and Space Administration Website");
	}
	
	@Test(priority=4)
	public void testUsingXpath1()
	{
		when()
		.get()
		.then()
		.body(hasXPath("/rss/channel/language", containsString("en-US")));
	}

	@Test(priority=5)
	public void testUsingXpath2()
	{
		when()
		.get()
		.then()
		.body(hasXPath("/rss/channel/language[text()='en-US']"));
	}
}
