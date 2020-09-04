

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:mem:test", "test", "test");
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE Person(id INT, NAME VARCHAR )");
            statement.execute("INSERT INTO Person VALUES (1, 'Alex')");
            statement.execute("INSERT INTO Person VALUES (2, 'Jenya')");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Person");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " " + resultSet.getString("name"));
            }
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println(connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
