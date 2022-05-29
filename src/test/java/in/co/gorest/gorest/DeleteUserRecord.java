package in.co.gorest.gorest;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserRecord extends TestBase {
    @Test
    public void deleteUsersRecord(){
        Response response = given()
                .header("Authorization","Bearer 6572e3479f20dc6c97a119b8ae7294488560c8b37c7c90cb7e948ad79050b840")
                .pathParam("id",3276)
                .when()
                .delete("/users/{id}");
        response.then().statusCode(204);
        response.prettyPrint();
    }
}
