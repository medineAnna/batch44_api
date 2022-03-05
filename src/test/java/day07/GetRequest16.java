package day07;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest16 extends JsonPlaceHolderBaseUrl {
       /*
   https://jsonplaceholder.typicode.com/todos/7

   {
   "userId": 1,
   "id": 7,
   "title": "illo expedita consequatur quia in",
   "completed": false
}
    */
    @Test
    public void test16(){
        //1) URL olusturma
        spec04.pathParams("first","todos","second",7);

        //2) expected(beklenen) data olustur
        Map<String,Object>expectedData=new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",7);
        expectedData.put("title","illo expedita consequatur quia in");
        expectedData.put("completed",false);

        System.out.println("expected Data = " + expectedData);

        //3) Request ve Response
        Response response= given().spec(spec04).when().get("/{first}/{second}");
        response.prettyPrint();

        //Datayi JSON'dan->  JAVA'a donusturme De-Serialization
        //Datayi JAVA'dan-> JSON'a donusturme Serialization denir

        Map<String,Object>actualData=response.as(HashMap.class); //responsden gelen datalari HashMap classina at
        System.out.println("Actua lData = " + actualData);

        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));
        Assert.assertEquals(expectedData.get("id"),actualData.get("id"));
        Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
        Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));

    }
}
