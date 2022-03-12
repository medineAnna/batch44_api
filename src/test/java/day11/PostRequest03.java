package day11;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostRequest03 extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
     {
     "userId": 55,
     "title": "Tidy your room",
     "completed": false
   }
Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
   {
     "userId": 55,
     "title": "Tidy your room",
     "completed": false,
     "id": …
    }
     */
    @Test
    public void testDataPost03(){
        spec04.pathParam("1","todos");

        JsonPlaceHolderTestData testObje=new JsonPlaceHolderTestData();
        JSONObject expectedRequestData=testObje.setUpData();
        System.out.println("expectedRequestData = " + expectedRequestData);

        Response response=given().contentType(ContentType.JSON)
                .spec(spec04)
                .auth().basic("admin","password123")
                .body(expectedRequestData.toString())
                .when()
                .post("/{1}");
        response.prettyPrint();

        //Matchers class ile
        response.then()
                .assertThat()
                .statusCode(expectedRequestData.getInt("statusCode"))
                .body("completed", equalTo(expectedRequestData.getBoolean("completed"))
                        ,"title",equalTo(expectedRequestData.getString("title"))
                        ,"userId",equalTo(expectedRequestData.getInt("userId")));

        //JsonPath ile
        JsonPath json=response.jsonPath();
        Assert.assertEquals(expectedRequestData.getInt("statusCode"),response.getStatusCode());
        Assert.assertEquals(expectedRequestData.getInt("userId"),json.getInt("userId"));
        Assert.assertEquals(expectedRequestData.getString("title"),json.getString("title"));
        Assert.assertEquals(expectedRequestData.getBoolean("completed"),json.getBoolean("completed"));

        //Deserialization
        HashMap<String,Object>actualDataMap=response.as(HashMap.class);
        Assert.assertEquals(expectedRequestData.getString("title"),actualDataMap.get("title"));
        Assert.assertEquals(expectedRequestData.getInt("userId"),actualDataMap.get("userId"));
        Assert.assertEquals(expectedRequestData.getBoolean("completed"),actualDataMap.get("completed"));
    }
}
