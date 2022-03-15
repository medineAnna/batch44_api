package ornekler;

import base_url.DammyBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.DummyPojo01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyRequestPojo extends DammyBaseUrl {

    /**    http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde

     Status kodun 200 olduğunu,

     5. Çalışan isminin "Airi Satou" olduğunu,

     çalışan sayısının 24 olduğunu,

     Sondan 2. çalışanın maaşının 106450 olduğunu

     40,21 ve 19 yaslarında çalışanlar olup olmadığını ve

     11. Çalışan bilgilerinin asagidaki gibi oldugunu test edin.

     {

     "id": 11,
     "employee_name": "Jena Gaines",
     "employee_salary": 90560,
     "employee_age": 30,
     "profile_image": ""

     } */
   @Test
    public void test01(){
       spec02.pathParam("1","employees");

       //expected data olustur
       DummyPojo01 expectedData=new DummyPojo01(11,"Jena Gaines",90560,30,"");
       System.out.println("expectedDummyData = " + expectedData);

       Response response= RestAssured.given().contentType(ContentType.JSON).spec(spec02).when().get("/{1}");
       response.prettyPrint();

       //De-serialization with Pojo
       pojos.DummyResponsePojo actualData = response.as(pojos.DummyResponsePojo.class); // De-Serialization islemi yaptik.
       System.out.println("actualData = " + actualData);

       Assert.assertEquals(     expectedData.getEmployee_name(),       actualData.getData().get(10).getEmployee_name()    );
       Assert.assertEquals(     expectedData.getEmployee_salary(),     actualData.getData().get(10).getEmployee_salary()   );
       Assert.assertEquals(     expectedData.getEmployee_age(),        actualData.getData().get(10).getEmployee_age()   );
       Assert.assertEquals(     expectedData.getProfile_image(),       actualData.getData().get(10).getProfile_image()   );
       Assert.assertEquals(     expectedData.getId(),                  actualData.getData().get(10).getId()                );




       HashMap<String ,Object> actualData02 = response.as(HashMap.class); // De-Serialization islemi yaptik.



       Assert.assertEquals(expectedData.getId(),              ( (Map)  ( (List) actualData02.get("data") ) .get(10)  ) .get("id")      );
       Assert.assertEquals(expectedData.getEmployee_age(),     ((Map) ((List) actualData02.get("data")).get(10)) .get("employee_age")                                                         );




   }
}
