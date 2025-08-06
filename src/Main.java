import database.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        try {
            Connection con = factory.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM aluno"
            );
            ResultSet rs = stmt.executeQuery();
              while(rs.next()){
                String matricula = rs.getString("matricula");
                String nome = rs.getString(2);
                String email = rs.getString("email");
                System.out.println(matricula + ", " + nome + ", "+ email);
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
