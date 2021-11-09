import java.util.Arrays;

public class ApiMapOutput {
    public static String splitMap(String input){

        /*String test = "2021-11-09 15:00:00=272.31";

        String[] testSplit = test.split(" ");
        String[] testSplit2 = testSplit[1].split("=");

        System.out.println("");
        System.out.println(Arrays.toString(testSplit));*/


        String[] inputSplit = input.split(",");
        System.out.println(Arrays.toString(inputSplit));

        //System.out.println(inputSplit[0]);

        for (int i = 0; i < inputSplit.length; i++) {
            System.out.println(inputSplit[i]);
        }


        return null;
    }
}
