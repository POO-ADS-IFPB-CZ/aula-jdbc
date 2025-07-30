package database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class ConnectionFactory {

    private Connection connection;

    public Connection getConnection()
            throws IOException {
        Properties props = new Properties();
        FileReader reader = new FileReader("database.properties");
        props.load(reader);
        System.out.println(props);
        return null;
    }

}
