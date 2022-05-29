package in.co.gorest.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SearchJsonPathExample {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath="/public/v2";
        response = given()
                .when()
                .get("/users")
                .then().statusCode(200);

    }


    // 1].to verify Total records are 20
    @Test
    public void test001() {
        List<String> data = response.extract().path("");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total records are  : " + data.size());
        System.out.println("------------------End of Test---------------------------");
    }
    // 2] to verify id  3855 has name =Sanka Agarwal VM
    @Test
    public void test002() {
        int id = response.extract().path("[2].id");
        String name = response.extract().path("[2].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of name has id is 3269 : " + id);
        System.out.println("The value of name has id is 3269 : " + name);
        System.out.println("------------------End of Test---------------------------");
    }
    //3].to verify id 3855 has email =agarwal_vm_sanka@murray.net
    @Test
    public void test003() {
        int id = response.extract().path("[2].id");
        String email = response.extract().path("[2].email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of name has id is 3269 : " + id);
        System.out.println("The value of name has id is 3269 : " + email);
        System.out.println("------------------End of Test---------------------------");
    }
    // 4]All ID has status = active
    @Test
    public void test004() {
        List<String> status = response.extract().path("status");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Value message : "+ status);
        System.out.println("------------------End of Test---------------------------");
    }
    // 5].id 2877 has gender = female
    @Test
    public void test005() {
        int id = response.extract().path("[2].id");
        String gen = response.extract().path("[2].gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of name has id is 3269 : " + id);
        System.out.println("The value of gender has id is 3269 : " + gen);
        System.out.println("------------------End of Test---------------------------");
    }
    // 6].id 3853 has gender =male
    @Test
    public void test006() {
        int id = response.extract().path("[1].id");
        String gen = response.extract().path("[1].gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of name has id is 3270 : " + id);
        System.out.println("The value of gender has id is 3270 : " + gen);
        System.out.println("------------------End of Test---------------------------");
    }

}
