import java.util.Arrays;

public class SplitString {
    public static String[] splitString(String input){

        String[] inputSplit = input.split(",");
        //System.out.println(Arrays.toString(inputSplit));

        //System.out.println(inputSplit[0]);

        /*for (int i = 0; i < inputSplit.length; i++) {
            System.out.println(inputSplit[i]);
        }*/

        return inputSplit;
    }
}
