import Utility.JsonResponseParser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ApiExecutorTest {

    public static final String TESTAPI_PROPERTIES = "testapi.properties";
    JsonResponseParser jsonResponseParser;
    ApiRequest request;
    ConfigurationFileReader readconfig;
    private String gallery;


    @Before
    public void setUp() throws IOException {
        initialiseObjects();


    }

    private void initialiseObjects() throws IOException {
         readconfig= new ConfigurationFileReader(TESTAPI_PROPERTIES);
         request= new ApiRequest(readconfig.getRequestUrl(), readconfig.getRequestMethod());
         jsonResponseParser = new JsonResponseParser(request.createAndSendRequest());

    }

    @Test
    public void verifyName(){
        assertEquals(jsonResponseParser.getNameFromRootObject(), "Carbon credits");
    }

    @Test
    public void isCanRelist(){
        assertTrue(jsonResponseParser.isCanResist());
    }

    @Test
    public void verifyDescriptionTextInPromotions(){
        gallery = "Gallery";
        assertTrue(jsonResponseParser.getPromotionDescriptionWithName(gallery).contains("2x larger image"));
    }

    @After
    public void tearDown(){
        request.closeConnection();

    }





}
