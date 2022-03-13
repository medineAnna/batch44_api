package day12;

import base_url.DammyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import test_data.DummyTestData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class DeleteRequest01 extends DammyBaseUrl {
    /*
    http://dummy.restapiexample.com/api/v1/delete/2 bir DELETE request gönderdiğimde
 Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
 {
 "status": "success",
 "data": "2",
 "message": "Successfully! Record has been deleted"
 }
     */
    @Test
    public void test01(){
        //url olustur
        spec02.pathParams("1","delete","2",2);

        DummyTestData testData=new DummyTestData();
        JSONObject expectedData=testData.setUpDeleteExpectedData();

        Response response=given()
                .contentType(ContentType.JSON)
                .spec(spec02)
                .auth().basic("admin","password123")
                .when().delete("/{1}/{2}");
        response.prettyPrint();

        //Matchers class ile
        response.then().assertThat().statusCode(200)
                .body("status", equalTo(expectedData.getString("status"))
                        ,"data",equalTo(expectedData.getString("data"))
                        ,"message",equalTo(expectedData.getString("message")));
    }
}
