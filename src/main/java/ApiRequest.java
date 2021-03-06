import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ApiRequest {

    private static final String CONTENT_TYPE = "Content-Type";
    private URL url;
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

    private URL getURL(){
        return url;
    }

    private void setConnection() throws IOException {
        con= (HttpURLConnection) getURL().openConnection();
    }

    private void setRequestMethod(){
        con.setRequestProperty(CONTENT_TYPE, requestMethod);
    }

    public String createAndSendRequest() throws IOException {
        setURL();
        setConnection();
        setRequestMethod();
        return getResponse();
    }

    private String getResponse() throws IOException {
        Scanner scanResponse= new Scanner(url.openStream());
        StringBuilder responseBuilder= new StringBuilder();
        while(scanResponse.hasNext())
            responseBuilder.append(scanResponse.nextLine());
        scanResponse.close();
        return responseBuilder.toString();

    }

    public void closeConnection(){
        con.disconnect();
    }



}


