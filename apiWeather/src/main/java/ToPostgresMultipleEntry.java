import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToPostgresMultipleEntry {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/firstPostgres";
        String username = "postgres";
        String password = "Postgres1!";

        List<String> dates = new ArrayList<>();
        dates.add("19/11/21");
        dates.add("20/11/21");

        List<String> temps = new ArrayList<>();
        temps.add("300");
        temps.add("301");

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


            connection.close();

        } catch (SQLException e) {
            System.out.println("error connecting to postgres server");
            e.printStackTrace();
        }


    }
}
