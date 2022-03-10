package day10;

import base_url.DammyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.DummyTestData;

import java.util.*;

import static io.restassured.RestAssured.given;

public class GetRequest23 extends DammyBaseUrl {
    /*
   http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
   Status kodun 200 olduğunu,
   14. Çalışan isminin "Haley Kennedy" olduğunu,
   Çalışan sayısının 24 olduğunu,
   Sondan 3. çalışanın maaşının 675000 olduğunu
   40,21 ve 19 yaslarında çalışanlar olup olmadığını
   10. Çalışan bilgilerinin bilgilerinin aşağıdaki gibi
   {
           "id": 10,
           "employee_name": "Sonya Frost",
           "employee_salary": 103600,
           "employee_age": 23,
           "profile_image": ""
    }
     olduğunu test edin.
   */
    @Test
    public void test23(){
        spec02.pathParams("1","api","2","v1","3","employees");
        
        //2. Ecpected Data olustur
        DummyTestData expectedData=new DummyTestData();
        HashMap<String,Object>expectedTestDataMap=expectedData.setUpTestData();
        System.out.println("expectedTestDataMap = " + expectedTestDataMap);

        //3. request response
        Response response=given().spec(spec02).contentType(ContentType.JSON).when().get("/{1}/{2}/{3}");
        response.prettyPrint();

        //4. Dogrulama
        //1.Yontem Deserialization
        HashMap<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);

        //Status kodun 200 olduğunu,
        Assert.assertEquals(expectedTestDataMap.get("statusCode"),response.getStatusCode());

        // 14. Çalışan isminin "Haley Kennedy" olduğunu,
        Assert.assertEquals(expectedTestDataMap.get("ondorduncuCalisan")
                ,((Map)((List)actualDataMap.get("data")).get(13)).get("employee_name"));

        // Çalışan sayısının 24 olduğunu,  size almak lazim
        Assert.assertEquals(expectedTestDataMap.get("calisanSayisi")
                ,((List<?>) actualDataMap.get("data")).size());

        // Sondan 3. çalışanın maaşının 675000 olduğunu
        //1.Yol
        Assert.assertEquals(expectedTestDataMap.get("sondanUcuncuCalisanMaasi")
                ,((Map)((List)actualDataMap.get("data")).get(((List)actualDataMap.get("data")).size()-3)).get("employee_salary"));

        //2. Yol
        int dataSize = ((List<?>) actualDataMap.get("data")).size();
        Assert.assertEquals(expectedTestDataMap.get("sondanUcuncuCalisanMaasi")
                ,((Map)((List<?>) actualDataMap.get("data")).get(dataSize-3)).get("employee_salary"));

        // 40,21 ve 19 yaslarında çalışanlar olup olmadığını
        //1.yol
        List<Integer>actualYasListesi=new ArrayList<>();
        for (int i = 0; i <dataSize; i++) {
            actualYasListesi.add(((Integer) ((Map)((List)actualDataMap.get("data")).get(i)).get("employee_age")));
        }
        System.out.println("actualYasListesi = " + actualYasListesi);
        Assert.assertTrue(actualYasListesi.containsAll((Collection<?>) expectedTestDataMap.get("arananYaslar")));

        //2. Yol
        List<Integer> employee_age = new ArrayList<>();
        for(int i=0 ; i < ((List)actualDataMap.get("data")).size() ; i++){
            employee_age.add((Integer) ((Map)((List)actualDataMap.get("data")).get(i)).get("employee_age"));
            Assert.assertTrue(employee_age.containsAll((Collection<?>) expectedTestDataMap.get("arananYaslar")));
    }
}}
