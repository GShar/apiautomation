import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationFileReader {
    private static final String REQUEST_URL_PROPERTY_NAME = "requestURL";
    private static final String REQUEST_METHOD_PROPERTY_NAME = "requestMethod";
    private Properties props;
    private String propertyFileName;

public ConfigurationFileReader(String _propertyFileName){
    propertyFileName=_propertyFileName;
    props= new Properties();
}

    private Properties readConfigFile() {
        InputStream inputStream=null;
    try {
            inputStream=getClass().getClassLoader().getResourceAsStream(propertyFileName);
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(inputStream!=null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return props;
    }

    public String getRequestUrl() throws IOException {
        return readConfigFile().getProperty(REQUEST_URL_PROPERTY_NAME);
    }

    public String getRequestMethod() throws IOException {
        return  readConfigFile().getProperty(REQUEST_METHOD_PROPERTY_NAME);
    }



}
