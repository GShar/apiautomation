import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiRequest {

    private static final String CONTENT_TYPE = "Content-Type";
    URL url;
    private HttpURLConnection con;
    private String requestURL;
    private String requestMethod;
    public ApiRequest(String _requestURL, String _requestMethod){
        requestURL=_requestURL;
        requestMethod=_requestMethod;
    }

    private void setURL() throws MalformedURLException {
        url= new URL(requestURL);
    }

    public URL getURL(){
        return url;
    }

    private void setConnection() throws IOException {
        con= (HttpURLConnection) getURL().openConnection();
    }

    private void setRequestMethod(){
        con.setRequestProperty(CONTENT_TYPE, requestMethod);
    }

    public void sendRequest() throws IOException {
        setURL();
        setConnection();
        setRequestMethod();
    }



}


