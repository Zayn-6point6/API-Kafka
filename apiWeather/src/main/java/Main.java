import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        int cityID = 524901;
        ArrayList country = Location.getInfo(cityID);

        List apiOutputList = DateTempAndFeelsLike.getWeatherList(cityID);
        System.out.println("Date, Temp & Feels like - List of Lists Format:");
        System.out.println("Date & Time: "  + apiOutputList.get(0));
        System.out.println("Temp:        "  + apiOutputList.get(1));
        System.out.println("Feels Like:  "  + apiOutputList.get(2));


        System.out.println("Producer Write");
        SampleProducerString weatherDates = new SampleProducerString(apiOutputList.get(0).toString()); //sending date and time of forecast
        SampleProducerString weatherTemp = new SampleProducerString(apiOutputList.get(1).toString());
        SampleProducerString weatherFeelsLike = new SampleProducerString(apiOutputList.get(2).toString());



        //JSONObject data_obj = HttpGetFunction.doHttpGet(cityID);
        //SampleProducerString sampleProducerString = new SampleProducerString(data_obj.toJSONString()); //sending entire API's JSON



        //SampleProducerString producerBlankLines = new SampleProducerString("--\n--\n--\n");  //just to see records clearer in terminal
    }
}
