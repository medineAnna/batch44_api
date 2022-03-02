package get_http_request;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequest02 {

    @Test
    public void test02(){
        String url="https://reqres.in/api/users";

        Response response=given().when().get(url);

       /* response.prettyPrint();    body'i getirir
        response.then().log().all(); herseyi getirir*/

        response.prettyPeek();       //herseyi getirir

        //headers test ettik
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK");

        //body;yi test ettik
        response.then().body("data[1].first_name", equalTo("Janet")
                ,"data[1].last_name",equalTo("Weaver")
                ,"data[1].email",equalTo("janet.weaver@reqres.in"));

        response.then().body("data[2].id",equalTo(3)
                ,"data[2].email",equalTo("emma.wong@reqres.in")
                ,"data[2].first_name",equalTo("Emma")
                ,"data[2].last_name",equalTo("Wong")
                ,"data[2].avatar",equalTo("https://reqres.in/img/faces/3-image.jpg"));
    }
}
