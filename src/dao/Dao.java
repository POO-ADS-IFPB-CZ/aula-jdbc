package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    boolean salvar(T objeto) throws SQLException, IOException, ClassNotFoundException;
    boolean atualizar(T objeto);
    boolean deletar(T objeto);
    List<T> listar() throws SQLException, IOException, ClassNotFoundException;

}
