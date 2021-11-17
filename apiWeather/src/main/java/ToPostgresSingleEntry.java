import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ToPostgresSingleEntry {
    public static void main(String[] args) {
       /* List<String> consumerOutput = new ArrayList<>();
        consumerOutput = Consumer.consumer();
        System.out.println(consumerOutput);*/

        String jdbcURL = "jdbc:postgresql://localhost:5432/firstPostgres";
        String username = "postgres";
        String password = "Postgres1!";


        try {
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Connecting to Postgres Server");

            String sql = "INSERT INTO first_table (date, temp)" + " VALUES ('18/11/21', '290')";


            Statement statement = connection.createStatement();

            //statement.executeUpdate(sql);
            int rows = statement.executeUpdate(sql);
            if (rows > 0){
                System.out.println("A new row has been created");
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("error connecting to postgres server");
            e.printStackTrace();
        }


    }
}
