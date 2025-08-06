package dao;

import model.Aluno;

import java.util.List;

public class AlunoDao implements Dao<Aluno>{
    @Override
    public boolean salvar(Aluno objeto) {
        return false;
    }

    @Override
    public boolean atualizar(Aluno objeto) {
        return false;
    }

    @Override
    public boolean deletar(Aluno objeto) {
        return false;
    }

    @Override
    public List<Aluno> listar() {
        return List.of();
    }
}
