package day08;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetRequest20 extends JsonPlaceHolderBaseUrl {
    @Test
    public void test20(){
         /*
https://jsonplaceholder.typicode.com/todos/2
1) Status kodunun 200,
2) respose body'de,
         "completed": değerinin false
         "title": değerinin "quis ut nam facilis et officia qui"
         "userId" sinin 1 ve
    header değerlerinden
         "via" değerinin "1.1 vegur" ve
         "Server" değerinin "cloudflare" olduğunu test edin…
*/
        //1) Url olustur
        spec04.pathParams("1","todos","2",2);

        //2) Expected Data olustur
        HashMap<String,Object> expectedData=new HashMap<>();
        expectedData.put("statusCode",200);
        expectedData.put("completed",false);
        expectedData.put("userId",1);
        expectedData.put("via","1.1 vegur");
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("Server","cloudflare");

        //3) Request ve Response
        Response response=given().spec(spec04).when().get("/{1}/{2}");
        response.prettyPrint();

        //4) Dogrulama
        //1.yol Matchers class
        //Matcher ile
        response.then().statusCode((Integer)expectedData.get("statusCode")).headers("via",equalTo(expectedData.get("via"))
                ,"Server",equalTo(expectedData.get("Server")))
                .body("userId",equalTo(expectedData.get("userId"))
                        , "title",equalTo(expectedData.get("title"))
                ,"completed",equalTo(expectedData.get("completed")));

        //2.yol JsonPath ile
        JsonPath json=response.jsonPath();
        Assert.assertEquals(expectedData.get("statusCode"),response.statusCode());
        Assert.assertEquals(expectedData.get("via"),response.getHeader("via"));
        Assert.assertEquals(expectedData.get("Server"),response.getHeader("Server"));
        Assert.assertEquals(expectedData.get("userId"),json.getInt("userId"));
        Assert.assertEquals(expectedData.get("title"),json.getString("title"));
        Assert.assertEquals(expectedData.get("completed"),json.getBoolean("completed"));

        //3.yol Deserialization
        HashMap<String, Object> actualData=response.as(HashMap.class);//
        System.out.println("ASctual Data = " + actualData);
        Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));
        Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
        Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));
    }
}
