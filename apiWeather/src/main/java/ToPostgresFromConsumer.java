import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToPostgresFromConsumer {
    public static void main(String[] args) {
        List<String>  consumerOutput = new ArrayList<>();
        consumerOutput = Consumer.consumer();

        String[] dates = SplitString.splitString(consumerOutput.get(0));
        String[] temps = SplitString.splitString(consumerOutput.get(1));
        String[] feels_like = SplitString.splitString(consumerOutput.get(2));



        String jdbcURL = "jdbc:postgresql://localhost:5432/firstPostgres";
        String username = "postgres";
        String password = "Postgres1!";


        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connecting to Postgres Server");

            String sql = "INSERT INTO first_table (date, temp, feels_like)" + " VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            int count = 0;
            for (int i = 0; i < dates.length; i++) {
                    statement.setString(1, dates[i]);
                    statement.setString(2, temps[i]);
                    statement.setString(3, feels_like[i]);

                    int rows = statement.executeUpdate();
                    /*if (rows > 0){
                        System.out.println("A new row has been created");
                    }*/
                    count++;
            }
            System.out.println("Number of rows created: " + count);


            connection.close();

        } catch (SQLException e) {
            System.out.println("error connecting to postgres server");
            e.printStackTrace();
        }
    }
}
