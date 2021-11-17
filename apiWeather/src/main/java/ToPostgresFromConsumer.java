import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToPostgresFromConsumer {
    public static void main(String[] args) {


        System.out.println("before consumer output");
        List<List<String>>  consumerOutput = new ArrayList<>();
        consumerOutput = Consumer.consumer();
        System.out.println("after consumer output");

        List<String> dates = consumerOutput.get(0);
        List<String> temps = consumerOutput.get(1);

        System.out.println("after consumer.get");
        System.out.println(dates);


        String jdbcURL = "jdbc:postgresql://localhost:5432/firstPostgres";
        String username = "postgres";
        String password = "Postgres1!";


        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connecting to Postgres Server");

            String sql = "INSERT INTO first_table (date, temp)" + " VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            for (int i = 0; i < dates.size(); i++) {
                    statement.setString(1, dates.get(i));
                    statement.setString(2, temps.get(i));

                    int rows = statement.executeUpdate();
                    if (rows > 0){
                        System.out.println("A new row has been created");
                    }
            }


            /*for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 5; j++) {
                    statement.setString(1, consumerOutput.get(i));
                    statement.setString(2, consumerOutput.get(i));

                    int rows = statement.executeUpdate();
                    if (rows > 0){
                        System.out.println("A new row has been created");
                    }
                }
            }*/


            connection.close();

        } catch (SQLException e) {
            System.out.println("error connecting to postgres server");
            e.printStackTrace();
        }


    }
}
