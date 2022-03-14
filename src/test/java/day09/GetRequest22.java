package day09;

import base_url.HerOkuAppBaseUrl;
import base_url.HerOkuBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest22 extends HerOkuAppBaseUrl {
    /*
https://restful-booker.herokuapp.com/booking/47
       {
           "firstname": "Ali",
           "lastname": "Can",
           "totalprice": 500,
           "depositpaid": true,
           "bookingdates": {
               "checkin": "2022-02-01",
               "checkout": "2022-02-11"
*/
    @Test
    public void test22(){
        spec05.pathParams("1","booking","2",41);

        HerOkuAppTestData expectedObje=new HerOkuAppTestData();
        HashMap<String,Object>exoectedDataMap=expectedObje.setUpTestData();
        System.out.println("exoectedDataMap = " + exoectedDataMap);

        // {firstname=Ali,
        // bookingdates={
        //               checkin=2022-02-01,
        //               checkout=2022-02-11},
        // totalprice=500,
        // depositpaid=true,
        // lastname=Can}

        Response response=given().spec(spec05).when().get("/{1}/{2}");
        response.prettyPrint();
        
        //1.yol Deserialization === Json formatindaki datayi java formatina cevirecegiz
        HashMap<String, Object> actualData=response.as(HashMap.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(exoectedDataMap.get("firstname"),actualData.get("firstname"));
        Assert.assertEquals(exoectedDataMap.get("lastname"),actualData.get("lastname"));
        Assert.assertEquals(exoectedDataMap.get("totalprice"),actualData.get("totalprice"));
        Assert.assertEquals(exoectedDataMap.get("depositpaid"),actualData.get("depositpaid"));
        Assert.assertEquals(((Map)exoectedDataMap.get("bookingdates")).get("checkin")
                ,((Map)actualData.get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map)exoectedDataMap.get("bookingdates")).get("checkout")
                ,((Map)actualData.get("bookingdates")).get("checkout"));

        //2.yol JsonPath
        JsonPath json=response.jsonPath();
        Assert.assertEquals(exoectedDataMap.get("firstname"),json.getString("firstname"));
        Assert.assertEquals(exoectedDataMap.get("lastname"),json.getString("lastname"));
        Assert.assertEquals(exoectedDataMap.get("totalprice"),json.getInt("totalprice"));
        Assert.assertEquals(exoectedDataMap.get("depositpaid"),json.getBoolean("depositpaid"));
        Assert.assertEquals(((Map<?, ?>) exoectedDataMap.get("bookingdates")).get("checkin"),
                json.getString("bookingdates.checkin"));
        Assert.assertEquals(((Map<?, ?>) exoectedDataMap.get("bookingdates")).get("checkout"),
                json.getString("bookingdates.checkout"));
    }
}
