package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GMIBankBaseUrl {
    protected RequestSpecification spec03;

    @Before
    public void setUp(){
        spec03=new RequestSpecBuilder().setBaseUri("https://www.gmibank.com/api").build();
    }
}
