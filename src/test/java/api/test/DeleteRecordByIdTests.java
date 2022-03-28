package api.test;

import dto.DateDto;
import dto.RecordDto;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class DeleteRecordByIdTests {

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im5ldWVyQGdtYWlsLmNvbSJ9.fmWsYTleRgSuss2V1yFPI5XtAFFogJHRk7ln_BZpXOo";
    int id;

    @BeforeMethod
    public void ensurePreconditions() {
        RestAssured.baseURI = "https://super-scheduler-app.herokuapp.com/";
        RestAssured.basePath = "api";

        RecordDto record = RecordDto.builder()
                .breaks(1)
                .currency("NIS")
                .date(DateDto.builder().dayOfMonth(1).dayOfWeek("1").month(1).year(2022).build())
                .hours(4)
                .id(0)
                .timeFrom("18:00")
                .timeTo("21:00")
                .title("Event")
                .totalSalary(300)
                .type("1")
                .wage(100)
                .build();

        id = given().header("Authorization", token)
                .body(record)
                .contentType(ContentType.JSON)
                .when()
                .post("record")
                .then()
                .assertThat().statusCode(200)
                .extract().path("id");
    }

    @Test
    public void deleteRecordByIdTest() {

        String status = given().header("Authorization", token)
                .when()
                .delete("record/" + id)
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("status", containsString(id + " was deleted"))
                .extract().path("status");
        System.out.println(status);
    }

}