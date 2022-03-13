package day12;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PatchRequest01 extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönderdiğimde
   {
      "title": "API calismaliyim"
     }
Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
{
 "userId": 10,
 "title": "API calismaliyim"
 "completed": true,
 "id": 198
}
     */
    @Test
    public void patchRequestTest01(){
        //url olustr
        spec04.pathParams("1","todos","2",198);

        //expected ve Request data olustur
        JsonPlaceHolderTestData testData=new JsonPlaceHolderTestData();

        JSONObject requestData=testData.setUpPatchRequestData();
        System.out.println("requestData = " + requestData);

        JSONObject expectedTestData=testData.setUpPatchExpectedData();
        System.out.println("expectedTestData = " + expectedTestData);

        //Request gonder
        Response response=given()
                .contentType(ContentType.JSON)
                .spec(spec04)
                .auth().basic("admin","password123")
                .body(requestData.toString())
                .when().patch("/{1}/{2}");
        response.prettyPrint();

        //De-Serialization
        HashMap<String,Object>actualdata=response.as(HashMap.class);
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(expectedTestData.getInt("userId"),actualdata.get("userId"));
        Assert.assertEquals(expectedTestData.getInt("id"),actualdata.get("id"));
        Assert.assertEquals(expectedTestData.getString("title"),actualdata.get("title"));
        Assert.assertEquals(expectedTestData.getBoolean("completed"),actualdata.get("completed"));
    }
}
