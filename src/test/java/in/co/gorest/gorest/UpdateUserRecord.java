package in.co.gorest.gorest;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import in.co.gorest.utils.TestUtils;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UpdateUserRecord extends TestBase {
    @Test
    public void createUserPageRecord(){
        UserPojo userPojo = new UserPojo();
        TestUtils testUtils = new TestUtils();
        userPojo.setName("johnsmit");
        userPojo.setEmail("smit"+ testUtils.getRandomValue()+"@gmail.com");
        userPojo.setGender("female");
        userPojo.setStatus("active");

        Response response = given()
                .header("Authorization","Bearer 6572e3479f20dc6c97a119b8ae7294488560c8b37c7c90cb7e948ad79050b840")
                .header("Content-Type","application/json")
                .pathParam("id",3282)
                .body(userPojo)
                .when()
                .patch("/users/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
