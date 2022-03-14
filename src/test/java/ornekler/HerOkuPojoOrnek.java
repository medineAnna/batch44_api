package ornekler;

import base_url.HerOkuBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.BookingDatesPojoOr;
import pojo.HerOkuPojo;
import pojo.HerOkuResponsePojo;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class HerOkuPojoOrnek extends HerOkuBaseUrl {
    /**
     https://restful-booker.herokuapp.com/booking
     { "firstname": "Ali",
     "lastname": "Can",
     "totalprice": 500,
     "depositpaid": true,
     "bookingdates": {
     "checkin": "2022-03-01",
     "checkout": "2022-03-11"
     }
     }
     gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,

     */
    @Test
    public void test01(){
        //url olustur
        spec05.pathParam("1","booking");

        //Expected Data olustur
        BookingDatesPojoOr bookingDatesPojoOr=new BookingDatesPojoOr("2022-03-01","2022-03-11");
        HerOkuPojo expectedHerOkuPojo=new HerOkuPojo("Ali","Can",500,true,bookingDatesPojoOr);

        //Post
        Response response=given().
                contentType(ContentType.JSON).spec(spec05)
                .body(expectedHerOkuPojo)
                .when().post("/{1}");
        response.prettyPrint();

        //De-serialization
        HerOkuResponsePojo actualData=response.as(HerOkuResponsePojo.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(expectedHerOkuPojo.getFirstname(),actualData.getBooking().getFirstname());
        Assert.assertEquals(expectedHerOkuPojo.getLastname(),actualData.getBooking().getLastname());
        Assert.assertEquals(expectedHerOkuPojo.getTotalPrice(),actualData.getBooking().getTotalPrice());
        Assert.assertEquals(expectedHerOkuPojo.isDepositPaid(),actualData.getBooking().isDepositPaid());

        Assert.assertEquals(expectedHerOkuPojo.getBookingdates().getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(expectedHerOkuPojo.getBookingdates().getCheckout(),actualData.getBooking().getBookingdates().getCheckout());
    }
}
