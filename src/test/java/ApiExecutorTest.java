import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ApiExecutorTest {

    public static final String TESTAPI_PROPERTIES = "testapi.properties";

    @Before
    public void setUp() throws IOException {
        ConfigurationFileReader readconfig= new ConfigurationFileReader(TESTAPI_PROPERTIES);
        ApiRequest request= new ApiRequest(readconfig.getRequestUrl(), readconfig.getRequestMethod());
        request.createAndSendRequest();
    }

    @Test
    public void verifyName(){
        System.out.println("test");
    }

    @Test
    public void verifyCanRelistisTrue(){
        System.out.println("test");
    }

    @Test
    public void verifyDescriptionTextinPromotions(){

    }





}
