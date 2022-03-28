package api.test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.RecordPeriodFilterRequestDto;
import dto.RecordsListModelResponseDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class RecordsPeriodTest {

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im5ldWVyN0BnbWFpbC5jb20ifQ.KLOX8DnXq3OzBidrOKpQu77XbkNmqEVmWBqj48wiv88";

    @BeforeMethod
    public void ensurePreconditions(){

        RestAssured.baseURI = "https://super-scheduler-app.herokuapp.com/";
        RestAssured.basePath = "api";
    }

    @Test
    public void recordsPeriodPositiveTest() {

        RecordPeriodFilterRequestDto period = RecordPeriodFilterRequestDto.builder()
                .monthFrom(1)
                .monthTo(3)
                .yearFrom(2021)
                .yearTo(2022)
                .build();

        given().header("Authorization", token)
                .body(period)
                .contentType(ContentType.JSON)
                .when()
                .get("recordsPeriod")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(RecordsListModelResponseDto.class);

    }


}
