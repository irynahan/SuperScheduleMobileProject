package api.test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.DateDto;
import dto.RecordDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class AddNewRecordTest {

    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im5ldWVyN0BnbWFpbC5jb20ifQ.KLOX8DnXq3OzBidrOKpQu77XbkNmqEVmWBqj48wiv88";

    @BeforeMethod
    public void ensurePreconditions(){
        RestAssured.baseURI = "https://super-scheduler-app.herokuapp.com/";
        RestAssured.basePath = "api";
    }

    @Test
    public void addNewRecordPositiveTest(){
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


        int id = given().header("Authorization", token)
                .body(record)
                .contentType(ContentType.JSON)
                .when()
                .post("record")
                .then()
                .assertThat().statusCode(200)
                .extract().path("id");
        System.out.println(id);
        //21002
    }

}
