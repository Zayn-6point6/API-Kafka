import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.lang.reflect.Array;


import java.io.IOException;

public class Weather {
    public static void doHttpGet() {

        String apiKey = "3cb3858daf95395c68d867b887ccc8f3";
        String url = "http://api.openweathermap.org/data/2.5/forecast?id=524901&appid=" + apiKey;


        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse resp = null;


        try {
            resp = client.execute(get);
            HttpEntity entity = resp.getEntity();
            System.out.println("JSON Response");
            System.out.println(EntityUtils.toString(entity));

        }
        catch (IOException e) {
            System.out.println("something went wrong");
            e.printStackTrace();
        }

    }
}
