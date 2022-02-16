package homeWork8;
ы
import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHandler {

    private final static String PATH_DB = "jdbc:sqlite:src/main/java/homeWork8/Weather.db";

    private Connection connection;

    public DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(PATH_DB);
    }

    //add
    public void addEmployee(API weather) {
        PreparedStatement statement = null;
        try {
            statement = this.connection.prepareStatement("INSERT INTO Weather('city', 'LocalDate', 'weather', 'TemperatureMin', 'TemperatureMax') " +
                    "VALUES(?, ?, ?, ?, ?)"
            );
            statement.setObject(1, weather.getCity());
            statement.setObject(2, weather.getDate());
            statement.setObject(3, weather.g());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //SELECT
    public List<Employee> getAllEmployee() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM BaseInfoAboutEmployee");

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            double salary = resultSet.getDouble("salary");
            int age = resultSet.getInt("age");

            Employee employee = new Employee(name, salary, age);
            employees.add(employee);

        }

        return employees;

    }
}