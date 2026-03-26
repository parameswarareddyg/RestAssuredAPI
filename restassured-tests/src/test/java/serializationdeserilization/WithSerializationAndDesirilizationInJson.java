package serializationdeserilization;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class WithSerializationAndDesirilizationInJson {
//	 {
//	        "id": 1,
//	        "name": "Leanne Graham",
//	        "username": "Bret",
//	        "email": "Sincere@april.biz",
//	        "address": {
//	            "street": "Kulas Light",
//	            "suite": "Apt. 556",
//	            "city": "Gwenborough",
//	            "zipcode": "92998-3874",
//	            "geo": {
//	                "lat": "-37.3159",
//	                "lng": "81.1496"
//	            }
//	        },
//	        "phone": "1-770-736-8031 x56442",
//	        "website": "hildegard.org",
//	        "company": {
//	            "name": "Romaguera-Crona",
//	            "catchPhrase": "Multi-layered client-server neural-net",
//	            "bs": "harness real-time e-markets"
//	        }
//	    },

	@Test
	public void verify204NoContent()
	{
		Response response = RestAssured.when().delete("https://jsonplaceholder.typicode.com/users/1");
		Assert.assertEquals(response.statusCode(), 200,"Expected Value");
		Assert.assertEquals(response.getBody().toString().isEmpty(), 204,"Expected value");	
	}
	//200
	@Test
	public void getUserDetails()
	{
		Response response= get("https://jsonplaceholder.typicode.com/users/1");
		Assert.assertEquals(response.statusCode(),200,"Expected value");
		PersonDetails person = response
				.as(PersonDetails.class);
		person.displayRecord();
		Assert.assertEquals(person.getId(), 1);
	}
	
	
	//201
	@Test
	public void postUserDetails() {
		Geo geo = new Geo();
		geo.setLat("-37.3159");
		geo.setLng("81.1496");

		Address address= new Address();
		address.setStreet("Kulas Light");
		address.setSuite("Apt. 556");
		address.setCity("Gwenborough");
		address.setZipcode("92998-3874");
		address.setGeo(geo);

		PersonDetails person = new PersonDetails();
		person.setId(101);
		person.setName("Leanne Graham");
		person.setUsername("Bret");
		person.setEmail("Sincere@april.biz");
		person.setPhone("1-770-736-8031 x56442");
		person.setWebsite("hildegard.org");
		
		Company company = new Company();
		company.setName("Romaguera-Crona");
		company.setCatchPhrase("Multi-layered client-server neural-net");
		company.setBs("harness real-time e-markets");
		
		person.setCompany(company);

		given()
		.baseUri("https://jsonplaceholder.typicode.com")
		.contentType(ContentType.JSON)
		.body(person)
		.when()
		.post("/users")
		.then()
		.statusCode(201);
	}

	
	//204
	
}
