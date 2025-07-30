import database.ConnectionFactory;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        try {
            if(factory.getConnection()!=null){
                System.out.println("Conectado com sucesso!");
            }
        } catch (IOException e) {
            //Problema no arquivo de propriedades
            throw new RuntimeException(e);
        } catch (SQLException e) {
            //Problema nos parâmetros da conexão
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            //Problema no driver do JDBC
            throw new RuntimeException(e);
        }
    }

}
