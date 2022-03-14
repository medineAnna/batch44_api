package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerOkuBaseUrl {
    protected RequestSpecification spec05;

    @Before
    public void baseUrlSetUp(){
        spec05=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}
