package homeWork8;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException {

        try {
            DbHandler dbHandler = new DbHandler();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        API weather = new API(API.objectMapper);
        System.out.print(API.getWeather());

    }
}
