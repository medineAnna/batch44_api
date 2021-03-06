package test_data;

import org.json.JSONObject;

import java.util.HashMap;

public class HerOkuAppTestData {
    public HashMap<String,Object>setUpTestData(){
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
        HashMap<String,Object>bookingDates=new HashMap<>();
        bookingDates.put("checkin","2022-02-01");
        bookingDates.put("checkout","2022-02-11");

        HashMap<String,Object>expectedData=new HashMap<>();
        expectedData.put("firstname","Ali");
        expectedData.put("lastname","Can");
        expectedData.put("totalprice",700);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingDates);

        return expectedData;
    }
    /*
       https://restful-booker.herokuapp.com/booking
       { "firstname": "Ali",
                  "lastname": "Can",
                  "totalprice": 500,
                  "depositpaid": true,
                  "bookingdates": {
                      "checkin": "2022-03-01",
                      "checkout": "2022-03-11"
                   } */
    public JSONObject setUpTestAndRequestData(){
        JSONObject bookingsDate=new JSONObject();
        bookingsDate.put("ckeckin","2021-01-05");
        bookingsDate.put("ckeckout","2021-01-10");

        JSONObject expectedRequest=new JSONObject();
        expectedRequest.put("firstname","Batch30");
        expectedRequest.put("lastname","bitti");
        expectedRequest.put("totalprice",123);
        expectedRequest.put("depositpaid",false);
        expectedRequest.put("bookingdates",bookingsDate);
        return expectedRequest;
    }
}
