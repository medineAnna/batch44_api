package day12;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.TodosPojo;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo01 extends JsonPlaceHolderBaseUrl {
     /*
    https://jsonplaceholder.typicode.com/todos url ‘ine bir request gönderildiğinde
 Request body{
 "userId": 21,
 "id": 201,
 "title": "Tidy your room",
 "completed": false
}
 Status kodun 201, response body ‘nin ise
{
 "userId": 21,
 "id": 201,
 "title": "Tidy your room",
 "completed": false
 }
     */
    @Test
    public void test(){
        spec04.pathParam("1","todos");
        TodosPojo requesteExpected=new TodosPojo(21,201,"Tidy your room",false);
        System.out.println("requesteExpected = " + requesteExpected);

        Response response=given().contentType(ContentType.JSON)
                .spec(spec04)
                .auth().basic("admin","password123")
                .body(requesteExpected).when().post("/{1}");
        response.prettyPrint();

        //De-serializataion
        TodosPojo actualData=response.as(TodosPojo.class);

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(requesteExpected.getUserId(),actualData.getUserId());
        Assert.assertEquals(requesteExpected.getId(),actualData.getId());
        Assert.assertEquals(requesteExpected.getTitle(),actualData.getTitle());
        Assert.assertEquals(requesteExpected.isCompleted(),actualData.isCompleted());
    }
    
}
