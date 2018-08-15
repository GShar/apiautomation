import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiRequest {

    public static final String CONTENT_TYPE = "Content-Type";
    URL url;
    HttpURLConnection con;

    public void setURL(String requestURL) throws MalformedURLException {
        url= new URL(requestURL);
    }

    public URL getURL(){
    return url;
    }

    public void setConnection() throws IOException {
        con= (HttpURLConnection) getURL().openConnection();
    }

    public void setRequestMethod(String requestMethod){
        con.setRequestProperty(CONTENT_TYPE, requestMethod);

    }

}


