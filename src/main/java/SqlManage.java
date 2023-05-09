import java.sql.*;

public class SqlManage {

    public void sqlStart() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "testuser", "test");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            System.out.printf("id=%d, name=%s, age=%d\n", id, name, age);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
