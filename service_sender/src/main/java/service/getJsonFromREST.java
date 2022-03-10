package service;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class getJsonFromREST {
    private static final String REST_URI_GET = "http://localhost:8090/service_accountant_war/accountant";

    public static String getJsonFromREST(){
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(REST_URI_GET);
        String line = "";
        StringBuilder result = new StringBuilder();

        try {
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
