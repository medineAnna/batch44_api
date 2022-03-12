package test_data;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {
    public Map<String,Object>setUpTestData(){
        HashMap<String,Object> expectedData=new HashMap<>();
        expectedData.put("statusCode",200);
        expectedData.put("completed",false);
        expectedData.put("userId",1);
        expectedData.put("via","1.1 vegur");
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("Server","cloudflare");

        return expectedData;
    }

    /*{
        "userId": 55,
        "title": "Tidy your room",
        "completed": false
    } */
    public JSONObject setUpData(){
        JSONObject expectedRequest=new JSONObject();
        expectedRequest.put("statusCode",201);
        expectedRequest.put("userId",55);
        expectedRequest.put("title","Tidy your room");
        expectedRequest.put("completed",false);
        return expectedRequest;
    }

    /*{
 "userId": 21,
 "title": "Wash the dishes",
 "completed": false
    } */
    public JSONObject setUpPutData(){
        JSONObject expectedRequest=new JSONObject();
        expectedRequest.put("userId",21);
        expectedRequest.put("title","Wash the dishes");
        expectedRequest.put("completed",false);
        return expectedRequest;
    }
}
