import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationFileReader {
    public static final String REQUEST_URL_PROPERTY_NAME = "requestURL";
    public static final String REQUEST_METHOD_PROPERTY_NAME = "requestMethod";
    Properties props;

public ConfigurationFileReader(){
    props= new Properties();
}
    private String requestUrl;

    public void readConfigFile(String propertyFileName) throws IOException {
        InputStream inputStream=getClass().getClassLoader().getResourceAsStream(propertyFileName);
        props.load(inputStream);
    }

    public String getRequestUrl(){
        return props.getProperty(REQUEST_URL_PROPERTY_NAME);
    }

    public String getRequestMethod(){
        return  props.getProperty(REQUEST_METHOD_PROPERTY_NAME);
    }





}
