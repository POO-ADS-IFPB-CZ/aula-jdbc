import database.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        try {
            Connection con = factory.getConnection();
            PreparedStatement statement = con.prepareStatement(
            "INSERT INTO aluno (matricula,nome,email) VALUES (?,?,?)");
            statement.setString(1, "202112010001");
            statement.setString(2, "Maria");
            statement.setString(3, "maria@gmail.com");
            if(statement.executeUpdate()>0){
                System.out.println("Salvo com sucesso!");
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
