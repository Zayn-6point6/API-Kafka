import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Location {
    String country;
    String city;
    String latitude;
    String longitude;

    Location(String country, String city, String latitude, String longitude){
        this.country = country;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public static ArrayList<String> getInfo(int cityID) {
        JSONObject data_obj = HttpGetFunction.doHttpGet(cityID);

        //json
        System.out.print("JSON: ");
        System.out.print(data_obj);
        System.out.println("\n");

        //country + city
        JSONObject city_obj = (JSONObject) data_obj.get("city");  //when json equals "city"
        String country = city_obj.get("country").toString();
        String city = city_obj.get("name").toString();

        //long+lat
        JSONObject coord_obj = (JSONObject) city_obj.get("coord"); //when json equals "city/coord"
        String latitude = coord_obj.get("lat").toString();
        String longitude = coord_obj.get("lon").toString();




        Location location = new Location(country, city, latitude, longitude); //creating location object and populating it with the correct values
        /*getCountry(location);
        getCity(location);
        getLat(location);
        getLong(location);*/

        ArrayList<String> countryInfo = new ArrayList<String>(); //creating a list

        countryInfo.add(getCountry(location));  //adding items in the list using getFunction
        countryInfo.add(getCity(location));
        countryInfo.add(getLat(location));
        countryInfo.add(getLong(location));

        System.out.println("Country: " + countryInfo.get(0));
        System.out.println("City: " + countryInfo.get(1));
        System.out.println("Lat: " + countryInfo.get(2));
        System.out.println("Long: " + countryInfo.get(3));

        return countryInfo;
    }


    public static String getCountry(Location input){
        //System.out.println(input.country);
        return input.country;
    }
    public static String getCity(Location input){
        //System.out.println(input.city);
        return input.city;
    }
    public static String getLat(Location input){
        //System.out.println(input.latitude);
        return input.latitude;
    }
    public static String getLong(Location input){
        //System.out.println(input.longitude);
        return input.longitude;
    }
}
