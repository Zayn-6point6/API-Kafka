import java.util.ArrayList;
import java.util.List;

public class ToPostgres {
    public static void main(String[] args) {
        List<String> consumerOutput = new ArrayList<>();
        consumerOutput = Consumer.consumer();
        System.out.println(consumerOutput);


    }
}
