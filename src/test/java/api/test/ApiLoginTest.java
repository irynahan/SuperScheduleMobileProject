package api.test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import dto.AuthRequestDto;
import dto.AuthResponseDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class ApiLoginTest {

    @BeforeMethod
    public void ensurePreconditions(){
        RestAssured.baseURI = "https://super-scheduler-app.herokuapp.com/";
        RestAssured.basePath = "api";
    }

    @Test
    public void loginSuccessTest() {
        AuthRequestDto requestDto = AuthRequestDto.builder()
                .email("neuer7@gmail.com")
                .password("Neuer2027")
                .build();

        AuthResponseDto responseDto = given()
                .contentType("application/json")
                .body(requestDto)
                .when()
                .post("login")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);
        System.out.println(responseDto.getToken());
        System.out.println(responseDto.getStatus());
        System.out.println(responseDto.isRegistration());
        // eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im5ldWVyN0BnbWFpbC5jb20ifQ.KLOX8DnXq3OzBidrOKpQu77XbkNmqEVmWBqj48wiv88
    }
    @Test
    public void loginWithWrongPasswordTest(){
        given().body(AuthRequestDto.builder().email("neuer7@gmail.com").password("Neuer202").build())
                .contentType(ContentType.JSON)
                .post("login")
                .then()
                .assertThat().statusCode(401)
                .assertThat().body("message", containsString("Wrong email or password"));
    }

}
