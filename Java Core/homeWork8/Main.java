package homeWork8;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {

        DbHandler dbHandler = new DbHandler();

        dbHandler.addWeather();

        System.out.print(dbHandler.getAllWeather());

    }
}
