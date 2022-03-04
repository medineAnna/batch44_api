package day06;

import base_url.GMIBankBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class GetRequest13 extends GMIBankBaseUrl {
    /*http://www.gmibank.com/api/tp-customers/114351 adresindeki müşteri bilgilerini doğrulayın
    “firstName”: “Della”,
    “lastName”: “Heaney”,
    “mobilePhoneNumber”: “123-456-7893”,
    “address”: “75164 McClure Stream”,
    “country” : “USA”
    “state”: “New York43"
    “CREDIT_CARD”,hesabında 69700$ ,
    “CHECKING” hesabında 11190$*/
    @Test
    public void test13(){
        spec03.pathParams("first","tp-customers","second","114351");

        //http://www.gmibank.com/api
        Response response=given()
                .spec(spec03)
                .header("Authorization", "Bearer " + generateToken())
                .when().get("/{first}/{second}");
                             // /tp-customers/114351
        response.prettyPeek();

        //Matchers class ile
        response.then().assertThat().body("firstName", Matchers.equalTo("Della"),
                "lastName",Matchers.equalTo("Heaney"),
                "mobilePhoneNumber",Matchers.equalTo("123-456-7893"),
                "phoneNumber",Matchers.equalTo("213-456-7893"),
                "address",Matchers.equalTo("75164 McClure Stream"),
                "country.name",Matchers.equalTo("USA"),
                "state",Matchers.equalTo("New York43"),"accounts.balance[0]",Matchers.equalTo(69700),
                "accounts.balance[1]",Matchers.equalTo(11190));

        //JsonPath ile dogrulama
        JsonPath json=response.jsonPath();
        Assert.assertEquals("Della", json.getString("firstName"));
        Assert.assertEquals("Heaney", json.getString("lastName"));
        Assert.assertEquals("123-456-7893", json.getString("mobilePhoneNumber"));
        Assert.assertEquals("75164 McClure Stream", json.getString("address"));
        Assert.assertEquals("775164 McClure Stream", json.getString("country.name"));
        Assert.assertEquals("New York43", json.getString("state"));
        Assert.assertEquals(69700, json.getInt("accounts.balance[0]"));
        Assert.assertEquals(11190, json.getInt("accounts.balance[1]"));

    }
}
