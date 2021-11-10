import com.sun.jna.WString;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class TemperatureUsingHttpFunction {
    public static Map getTemp(int cityID){
        JSONObject data_obj = HttpGetFunction.doHttpGet(cityID); //entire json

        //initialising lists to store dates and temp
        List<String> dates_list = new ArrayList<>();
        List<String> temp_list = new ArrayList<>();

        //initialising map to store dates and temp
        //used LinkedHashMap to keep the order correct
        Map<String, String> map = new LinkedHashMap<String, String>( );

        JSONArray arr = (JSONArray) data_obj.get("list");  //creates a JSON array from data object where data object = "list"
        for (int i = 0; i < arr.size(); i++) {  //iterates through JSON array
            JSONObject new_obj = (JSONObject) arr.get(i);  //creates new object every iteration

            //date + time
            //System.out.println("Date + Time: " + new_obj.get("dt_txt"));

            //temperature
            JSONObject obj_main = (JSONObject) new_obj.get("main");  //creates final object when new_obj = "main"

            //System.out.println("temp: " + obj_main.get("temp"));  //prints from final object
            //System.out.println("feels_like: " + obj_main.get("feels_like"));
            //System.out.println();

            //storing dates and temp in two lists
            dates_list.add(new_obj.get("dt_txt").toString());
            temp_list.add(obj_main.get("temp").toString());

            //storing dates and temp in one list


            //storing dates and temp in map
            map.put(new_obj.get("dt_txt").toString(),obj_main.get("temp").toString());
        }

        //System.out.println("List output");
        //System.out.println("Dates list: "+dates_list);
        //System.out.println("Temp list: "+temp_list);
        //System.out.println();
        //System.out.println("map output");
        //System.out.println(map);


        return map;
    }
}
