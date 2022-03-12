package day11;

import base_url.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequest02 extends HerOkuAppBaseUrl {
    /*
    https://restful-booker.herokuapp.com/booking
    { "firstname": "Selim",
               "lastname": "Ak",
               "totalprice": 11111,
               "depositpaid": true,
               "bookingdates": {
                   "checkin": "2020-09-09",
                   "checkout": "2020-09-21"
                }
 }
 gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,
 "booking": {
         "firstname": " Selim ",
         "lastname": " Ak ",
         "totalprice":  11111,
         "depositpaid": true,
         "bookingdates": {
             "checkin": "2020-09-01",
              "checkout": " 2020-09-21”
         },
        }
olduğunu test edin
     */
    @Test
    public void test02(){
        //1.Url olustur
        spec05.pathParam("1","booking");

        //2. Expected Data ve Request olustur, tek JSONObject yeterli ayni oldugu icin
        HerOkuAppTestData testData=new HerOkuAppTestData();
        JSONObject expectedRequestData=testData.setUpTestAndRequestData();
        System.out.println("expectedRequestData = " + expectedRequestData);

        //Request gonder
        Response response=given()
                .contentType(ContentType.JSON)
                .spec(spec05)
                .auth().basic("admin","password123")
                .body(expectedRequestData.toString())
                .when()
                .post("/{1}");
        response.prettyPrint();
        
        // Deserialization
        HashMap<String, Object> actualDataMap=response.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);
        Assert.assertEquals(expectedRequestData.getString("firstname")
                ,((Map)actualDataMap.get("booking")).get("firstname"));
        Assert.assertEquals(expectedRequestData.getString("lastname")
                ,((Map)actualDataMap.get("booking")).get("lastname"));
        Assert.assertEquals(expectedRequestData.getInt("totalprice")
                ,((Map)actualDataMap.get("booking")).get("totalprice"));
        Assert.assertEquals(expectedRequestData.getBoolean("depositpaid")
                ,((Map)actualDataMap.get("booking")).get("depositpaid"));
        Assert.assertEquals(expectedRequestData.getJSONObject("bookingdates").getString("checkin")
                ,((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkin"));//ic ice map
        Assert.assertEquals(expectedRequestData.getJSONObject("bookingdates").getString("checkout")
                ,((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkout"));//ic ice map

        //JsonPath ile
        JsonPath json=response.jsonPath();
        Assert.assertEquals(expectedRequestData.getString("lastname"),json.getString("booking.lastname"));
        Assert.assertEquals(expectedRequestData.getString("firstname"),json.getString("booking.firstname"));
        Assert.assertEquals(expectedRequestData.getInt("totalproce"),json.getInt("booking.totalprice"));
        Assert.assertEquals(expectedRequestData.getBoolean("depositpaid"),json.getBoolean("booking.depositpaid"));
        Assert.assertEquals(expectedRequestData.getJSONObject("bookingsDate").getString("checkin")
                ,json.getString("booking.bookindates.checkin"));
        Assert.assertEquals(expectedRequestData.getJSONObject("bookingsDate").getString("checkout")
                ,json.getString("booking.bookindates.checkout"));


    }
}
