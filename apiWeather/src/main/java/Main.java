import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //String apiOutput = WeatherSingle.doHttpGet();

        //System.out.println("country from main file: " + apiOutput);

        //SampleProducer sampleProducer = new SampleProducer(apiOutput);

        //WeatherMultiple.doHttpGet();

        int city_ID = 524901;
        Map apiOutput = TemperatureUsingHttpFunction.getTemp(city_ID);
        System.out.println(apiOutput);
        SampleProducerString sampleProducer = new SampleProducerString(apiOutput.toString());


    }


}
