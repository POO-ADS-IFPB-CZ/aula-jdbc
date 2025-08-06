import dao.AlunoDao;
import model.Aluno;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        AlunoDao alunoDao = new AlunoDao();
        try {
            alunoDao.atualizar(
                    new Aluno("202012010001", "João da Silva",
                            "joao@gmail.com")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
