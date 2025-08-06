package dao;

import database.ConnectionFactory;
import model.Aluno;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDao implements Dao<Aluno>{

    @Override
    public boolean salvar(Aluno objeto) throws SQLException, 
            IOException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection con = connectionFactory.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(
                    "INSERT INTO aluno (matricula, nome, email)" +
                            "VALUES (?,?,?)"
            );
            pstmt.setString(1, objeto.getMatricula());
            pstmt.setString(2, objeto.getNome());
            pstmt.setString(3, objeto.getEmail());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean atualizar(Aluno objeto) {
        return false;
    }

    @Override
    public boolean deletar(Aluno objeto) throws SQLException, IOException, ClassNotFoundException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection con = connectionFactory.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(
                    "DELETE FROM aluno WHERE matricula = ?"
            );
            pstmt.setString(1, objeto.getMatricula());
            return pstmt.executeUpdate() > 0;
        }
    }

    @Override
    public List<Aluno> listar() throws SQLException, IOException,
            ClassNotFoundException {
        List<Aluno> alunos = new ArrayList<>();
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection connection = connectionFactory.getConnection()){
            PreparedStatement pstmt = connection.prepareStatement(
                    "SELECT * FROM aluno");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String matricula = rs.getString("matricula");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Aluno aluno = new Aluno(matricula, nome, email);
                alunos.add(aluno);
            }
        }
        return alunos;
    }
}
