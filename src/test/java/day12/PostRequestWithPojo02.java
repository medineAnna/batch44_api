package day12;

import base_url.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.BookingDatesPojo;
import pojo.BookingPojo;
import pojo.BookingResponsePojo;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo02 extends HerOkuAppBaseUrl {
     /*
    https://restful-booker.herokuapp.com/booking
    request body {
                   "firstname": "Selim",
                   "lastname": "Ak",
                   "totalprice": 15000,
                   "depositpaid": true,
                   "bookingdates": {
                       "checkin": "2020-09-09",
                       "checkout": "2020-09-21"
                    }
                 }
   Status code is 200
    response body  {
                            "bookingid": 11,
                            "booking": {
                                "firstname": "Selim",
                                "lastname": "Ak",
                                "totalprice": 15000,
                                "depositpaid": true,
                                "bookingdates": {
                                    "checkin": "2020-09-09",
                                    "checkout": "2020-09-21"
                                }
                            }
                         }
     */
    @Test
    public void testRequest(){
        spec05.pathParam("1","booking");

        //expected data
        BookingDatesPojo bookingDatesPojo=new BookingDatesPojo("2020-09-09","2020-09-21");
        System.out.println("bookingDatesPojo = " + bookingDatesPojo);

        BookingPojo bookingPojo=new BookingPojo("Selim","Ak",15000,true,bookingDatesPojo);
        System.out.println("bookingPojo = " + bookingPojo);

        Response response=given()
                .contentType(ContentType.JSON)
                .spec(spec05).auth().basic("admin","password123")
                .body(bookingPojo).when().post("/{1}");
        response.prettyPrint();

        //responsdeki bookingid ve booking degerleri actualData ya aktardik
        BookingResponsePojo actualData=response.as(BookingResponsePojo.class);

        Assert.assertEquals(200,response.getStatusCode());

        Assert.assertEquals(bookingPojo.getFirstname(),actualData.getBooking().getFirstname());
        Assert.assertEquals(bookingPojo.getLastname(),actualData.getBooking().getLastname());
        Assert.assertEquals(bookingPojo.getTotalprice(),actualData.getBooking().getTotalprice());
        Assert.assertEquals(bookingPojo.isDepositpaid(),actualData.getBooking().isDepositpaid());

        Assert.assertEquals(bookingPojo.getBookingdates().getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(bookingPojo.getBookingdates().getCheckout(),actualData.getBooking().getBookingdates().getCheckout());
    }
}
