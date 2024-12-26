package samztech.reporting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ReportingResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/reports")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

}