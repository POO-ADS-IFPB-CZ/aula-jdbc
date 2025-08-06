package dao;

import java.util.List;

public interface Dao<T> {

    boolean salvar(T objeto);
    boolean atualizar(T objeto);
    boolean deletar(T objeto);
    List<T> listar();

}
