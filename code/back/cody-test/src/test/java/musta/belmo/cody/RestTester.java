package musta.belmo.cody;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = musta.belmo.cody.Runner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestTester {

    @LocalServerPort
    private int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }


    @Test
    public void testSeatAllGET() {
        given().auth()
                .basic("test", "test")
                .when()
                .get("/seat/")
                .then()
                .statusCode(200)
                .body("$.size()", CoreMatchers.equalTo(5));

    }

    @Test
    public void testSeatGetByIdGET() {
        ValidatableResponse body = given().auth()
                .basic("test", "test")
                .when()
                .get("/seat/{id}", 1)
                .then()
                .statusCode(200)
                .body("$.id", CoreMatchers.equalTo(1));


    }

    @Test
    public void testSeatPOST() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"content\": \"test\"}")
                .auth()
                .basic("test", "test")
                .when()
                .post("/seat/")
                .then()
                .statusCode(200);
    }
}
