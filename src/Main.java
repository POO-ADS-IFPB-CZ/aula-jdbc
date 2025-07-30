import database.ConnectionFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        try {
            factory.getConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
