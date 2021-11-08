public class Main {
    public static void main(String[] args) {

        String apiOutput = WeatherSingleCountry.doHttpGet();

        System.out.println("country from main file: " + apiOutput);

        SampleProducer sampleProducer = new SampleProducer(apiOutput);
    }


}
