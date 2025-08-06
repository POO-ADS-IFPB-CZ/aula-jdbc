package database;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private Connection connection;

    public Connection getConnection()
            throws IOException, ClassNotFoundException, SQLException {
        //Ler as propriedades
        Properties props = new Properties();
        FileReader reader = new FileReader("database.properties");
        props.load(reader);

        //Fazendo a conexão
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
                props.getProperty("url"),
                props.getProperty("user"),
                props.getProperty("password")
        );

    }

}
