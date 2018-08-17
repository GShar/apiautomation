import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationFileReader {
Properties props;

public ConfigurationFileReader(){
    props= new Properties();
}
    private String requestUrl;

    public void readConfigFile(String propertyFileName) throws IOException {
        InputStream inputStream=getClass().getClassLoader().getResourceAsStream(propertyFileName);
        props.load(inputStream);
    }

    public String getPropertyByName(String propertyName){
        return props.getProperty(propertyName);
    }





}
