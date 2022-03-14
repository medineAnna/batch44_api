package day13;

import base_url.DammyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.Data;
import pojo.DummyPojo;

import static io.restassured.RestAssured.given;

public class GetRequestWithPojo01 extends DammyBaseUrl {
    /*
GET Request to the URL http://dummy.restapiexample.com/api/v1/employee/1
                            Status code is 200
                                 {
                                  "status": "success",
                                  "data": {
                                      "id": 1,
                                      "employee_name": "Tiger Nixon",
                                      "employee_salary": 320800,
                                      "employee_age": 61,
                                      "profile_image": ""
                                  },
                                  "message": "Successfully! Record has been fetched."
                                 }
 */
@Test
    public void test01(){
    spec02.pathParams("parametre1","employee","parametre2",1);

    //expected Data olustur
    Data data=new Data(1,"Tiger Nixon",320800,61,"");
    System.out.println("data = " + data);

    DummyPojo dummyPojo=new DummyPojo("success",data,"Successfully! Record has been fetched.");
    System.out.println("dummyPojo = " + dummyPojo);

    //
    Response response=given().contentType(ContentType.JSON).spec(spec02).when().get("/{parametre1}/{parametre2}");
    response.prettyPrint();

    //response olustur
    DummyPojo actualData=response.as(DummyPojo.class);
    System.out.println("actualData = " + actualData);

    Assert.assertEquals(200,response.getStatusCode());

    Assert.assertEquals(dummyPojo.getStatus(),actualData.getStatus());

    Assert.assertEquals(dummyPojo.getData().getId(),actualData.getData().getId());
    Assert.assertEquals(dummyPojo.getData().getEmployee_name(),actualData.getData().getEmployee_name());
    Assert.assertEquals(dummyPojo.getData().getemployee_salary(),actualData.getData().getemployee_salary());
    Assert.assertEquals(dummyPojo.getData().getEmployee_age(),actualData.getData().getEmployee_age());
    Assert.assertEquals(dummyPojo.getData().getprofile_image(),actualData.getData().getprofile_image());

    Assert.assertEquals(dummyPojo.getMessage(),actualData.getMessage());

    //Java  objesini json a cevir====Serialization
    //Gson gson=new Gson();
    //String jsonFormJava=gson.toJson(actualData);
}
}
