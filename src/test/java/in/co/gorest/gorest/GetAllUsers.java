package in.co.gorest.gorest;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsers extends TestBase {
    @Test
    public void getAllEmployeesRecord(){
        Response response = given()
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
