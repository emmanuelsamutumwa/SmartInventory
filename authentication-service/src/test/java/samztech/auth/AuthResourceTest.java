package samztech.auth;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
public class AuthResourceTest {

    @Test
    public void testLogin() {
        String jsonBody = "{\"username\": \"admin\", \"password\": \"password\"}";

        given()
                .contentType("application/json")
                .body(jsonBody)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .body(containsString("jwt"));
    }
}
