import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherMultiple {
    public static String doHttpGet(){

        try {

            String apiKey = "3cb3858daf95395c68d867b887ccc8f3";
            String urlString = "http://api.openweathermap.org/data/2.5/forecast?id=524901&appid=";
            URL url = new URL(urlString + apiKey);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                //Using the JSON simple library parse the string into a json object
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);  //creates a data object for the entire JSON


                //Get the required object from the above created object
                JSONObject obj = (JSONObject) data_obj.get("city");

                //Get the required data using its key
                System.out.println("country from weatherTwo file: " + obj.get("country"));

                String country = obj.get("country").toString();
                System.out.println("country from weatherTwo file: " + country);

                System.out.println(data_obj);


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
                return country;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
