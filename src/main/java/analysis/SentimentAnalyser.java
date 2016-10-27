package analysis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author nilstes
 */
public class SentimentAnalyser {
    
    public SentimentAnalyser() {
    }
    
    public int findSentiment(String text) {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpPost httppost = new HttpPost("http://localhost:8080/sentiment/webresources/sentiment");
            httppost.setEntity(new StringEntity(text, ContentType.create("text/plain", "UTF-8")));
            try (CloseableHttpResponse response = httpclient.execute(httppost)) {
                if(response.getStatusLine().getStatusCode() == 200) {
                    return Integer.parseInt(EntityUtils.toString(response.getEntity()));
                } else {
                    return -1;
                }
            }
        } catch(Exception e) {
            return -1;
        }
    }    
    
    public static void main(String[] args) throws Exception {
        System.out.println(new SentimentAnalyser().findSentiment("happy"));
    }
}
