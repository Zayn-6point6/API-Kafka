import com.sun.jna.WString;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class TemperatureUsingHttpFunction {
    public static String getTemp(){
        JSONObject data_obj = HttpGetFunction.doHttpGet();

        System.out.println("JSON:");
        System.out.println(data_obj);
        System.out.println();

        JSONArray arr = (JSONArray) data_obj.get("list");  //creates a JSON array from data object where data object = "list"
        for (int i = 0; i < arr.size(); i++) {  //iterates through JSON array
            JSONObject new_obj = (JSONObject) arr.get(i);  //creates new object every iteration

            //date + time
            System.out.println("Date + Time: " + new_obj.get("dt_txt"));


            //temperature
            JSONObject obj_main = (JSONObject) new_obj.get("main");  //creates final object when new_obj = "main"

            System.out.println("temp: " + obj_main.get("temp"));  //prints from final object
            System.out.println("feels_like: " + obj_main.get("feels_like"));
            System.out.println();
        }

        return null;
    }
}
