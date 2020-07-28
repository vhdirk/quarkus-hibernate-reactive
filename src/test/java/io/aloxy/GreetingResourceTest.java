package io.aloxy;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testResponseEndpoint() {
        given()
          .when().get("/response")
          .then()
             .statusCode(200)
             .body(is(""));
    }

    @Test
    public void testResponseStatusEndpoint() {
        given()
          .when().get("/response-status")
          .then()
             .statusCode(200)
             .body(is(""));
    }
}