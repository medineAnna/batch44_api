package day11;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;

public class PutRequest01 extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönerdiğimde
 {
 "userId": 21,
 "title": "Wash the dishes",
 "completed": false
 }
 Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
 {
 "userId": 21,
 "title": "Wash the dishes",
 "completed": false,
 "id": 198
 }
     */
    @Test
    public void testPut01(){
        spec04.pathParams("1","todos","2",198);
        JsonPlaceHolderTestData testObje=new JsonPlaceHolderTestData();
        JSONObject expectedRequestdata=testObje.setUpPutData();
        System.out.println("expectedRequestdara = " + expectedRequestdata);

        Response response=given().contentType(ContentType.JSON)
                .spec(spec04)
                .auth().basic("admin","password123")
                .body(expectedRequestdata.toString())
                .when()
                .put("/{1}/{2}");
        response.prettyPrint();

        //JsonPath ile
        JsonPath json=response.jsonPath();
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(expectedRequestdata.getBoolean("completed"),json.getBoolean("copmleted"));
        Assert.assertEquals(expectedRequestdata.getInt("userId"),json.getInt("userId"));
        Assert.assertEquals(expectedRequestdata.getString("title"),json.getString("title"));
    }
}
