package restAssuredTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CrudApiTests {

    // Base URL
    String baseUrl = "https://jsonplaceholder.typicode.com";

    // 🔹 CREATE (POST) → Expect 201 Created
    @Test
    public void testCreateUser() {
        String requestBody = "{ \"name\": \"John Doe\", \"username\": \"johnd\", \"email\": \"john@example.com\" }";

        Response response = RestAssured
                .given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(baseUrl + "/users");

        Assert.assertEquals(response.getStatusCode(), 201, "Expected 201 Created");
        System.out.println("Create Response: " + response.getBody().asString());
    }

    // 🔹 READ (GET) → Expect 200 OK
    @Test
    public void testGetUser() {
        Response response = RestAssured
                .when()
                .get(baseUrl + "/users/1");

        Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 OK");
        System.out.println("Get Response: " + response.getBody().asString());
    }

    // 🔹 UPDATE (PUT) → Expect 200 OK
    @Test
    public void testUpdateUser() {
        String requestBody = "{ \"name\": \"Jane Doe\", \"username\": \"janed\", \"email\": \"jane@example.com\" }";

        Response response = RestAssured
                .given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put(baseUrl + "/users/1");

        Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 OK");
        System.out.println("Update Response: " + response.getBody().asString());
    }

    // 🔹 DELETE → Expect 200 OK (JSONPlaceholder returns 200, but real APIs often return 204)
    @Test
    public void testDeleteUser() {
        Response response = RestAssured
                .when()
                .delete(baseUrl + "/users/1");

        // JSONPlaceholder returns 200, but in real APIs you’d assert 204
        Assert.assertEquals(response.getStatusCode(), 200, "Expected 200 OK (or 204 No Content in real APIs)");

        // Validate empty body (for 204, body should be empty)
        Assert.assertTrue(response.getBody().asString().isEmpty() || response.getBody().asString().equals("{}"),
                "Response body should be empty or minimal");
    }
}
