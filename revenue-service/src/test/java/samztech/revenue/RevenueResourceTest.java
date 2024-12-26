package samztech.revenue;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class RevenueResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/revenue")
          .then()
             .statusCode(200)
             .body(is("Hello from Quarkus REST"));
    }

}