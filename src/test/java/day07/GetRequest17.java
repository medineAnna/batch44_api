package day07;

import base_url.GMIBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest17 extends GMIBankBaseUrl {
  /*
   http://www.gmibank.com/api/tp-customers/114351 adresindeki müşteri bilgilerini doğrulayın

{
   "firstName": "Della",
   "lastName": "Heaney",
   "email": "ricardo.larkin@yahoo.com",
   "mobilePhoneNumber": "123-456-7893",
}
    */
    @Test
    public void test17(){
        //1) Url olustur
        spec03.pathParams("bir","tp-customers","iki","114351");

        //2) Expected Data olustur
        Map<String, Object>expectedData=new HashMap<>();
        expectedData.put("firstName","Della");
        expectedData.put("LastName","Heaney");
        expectedData.put("email","ricardo.larkin@yahoo.com");
        expectedData.put("mobilePhoneNumber","123-456-7893");

        System.out.println("Expected Data = " + expectedData);

        //3) Response ve Request
        Response response=given()
                .spec(spec03)
                .header("Authorization", "Bearer " + generateToken())
                .when()
                .get("/{bir}/{iki}");
        response.prettyPrint();

        //4) Dogrulama
        //De-Serialization

        Map<String, Object> actualData = response.as(HashMap.class); //De-Serialization YAPTIK
        System.out.println("ACTUAL DATA: " + actualData);

        Assert.assertEquals(expectedData.get("firstName"), actualData.get("firstName"));
        Assert.assertEquals(expectedData.get("lastName"), actualData.get("lastName"));
        Assert.assertEquals(expectedData.get("mobilePhoneNumber"), actualData.get("mobilePhoneNumber"));
        Assert.assertEquals(expectedData.get("email"), actualData.get("email"));

        Map<String, Object> actualData2 = response.as(Map.class); //De-Serialization YAPTIK
        System.out.println("ACTUAL DATA 2: " + actualData2);

        Assert.assertEquals(expectedData.get("firstName"), actualData2.get("firstName"));
        Assert.assertEquals(expectedData.get("lastName"), actualData2.get("lastName"));
        Assert.assertEquals(expectedData.get("mobilePhoneNumber"), actualData2.get("mobilePhoneNumber"));
        Assert.assertEquals(expectedData.get("email"), actualData2.get("email"));
    }
}
