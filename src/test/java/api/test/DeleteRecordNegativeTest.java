package api.test;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class DeleteRecordNegativeTest {
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im5ldWVyN0BnbWFpbC5jb20ifQ.KLOX8DnXq3OzBidrOKpQu77XbkNmqEVmWBqj48wiv88";


    @BeforeMethod
    public void ensurePreconditions() {
        RestAssured.baseURI = "https://super-scheduler-app.herokuapp.com/";
        RestAssured.basePath = "api";

    }

    @Test
    public void deleteRecordWithWrongIdTest() {
        given().header("Authorization", token)
                .when()
                .delete("record/" + 11)
                .then()
                .assertThat().statusCode(400)
                .assertThat().body("message", containsString("Record with id 11 doesn't exist!"));
    }
}
