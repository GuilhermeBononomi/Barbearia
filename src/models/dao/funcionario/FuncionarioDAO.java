package models.dao.funcionario;

import java.sql.Statement;
import java.util.ArrayList;

import models.dao.ConexaoBanco;

import java.sql.SQLException;
import java.sql.ResultSet;


public class FuncionarioDAO implements IFuncionario {
    ConexaoBanco conexao = new ConexaoBanco();
    Statement stmt = conexao.getStatement();

    public FuncionarioDAO() {
    }

    @Override
    public String atualizarFuncionario(int idFuncionario, int idUsuario, String cargo) {
        try {
            String SQL =
                    "UPDATE funcionario SET " +
                            "idusuario = " + Integer.toString(idUsuario) + ", " +
                            "cargo = '" + cargo + "' " +
                            "WHERE idfuncionario = " + Integer.toString(idFuncionario) + ";";

            stmt.executeUpdate(SQL);

            return "funcionario atualizado com sucesso!";
        } catch (SQLException error) {
            return "erro ao atualizar o funcionario" + error;
        }
    }   

    @Override
    public String deletarFuncionario(int idFuncionario) {
        try {
            String SQL = "DELETE FROM funcionario WHERE idfuncionario = " + Integer.toString(idFuncionario) + ";";
            stmt.executeUpdate(SQL);
            return "funcionario deletado com sucesso!";
        } catch (SQLException error) {
            return "erro ao deletar o funcionario" + error;
        }
    }   
    @Override
    public String inserirFuncionario(int idUsuario, String cargo) {
        try {
            Funcionario novo = new Funcionario();
            novo.setIdUsuario(idUsuario);
            novo.setCargo(cargo);

            String SQL = "INSERT INTO funcionario (idusuario, cargo) VALUES ("
                    + novo.getIdUsuario() + ","
                    + "'" + novo.getCargo() + "');";

            stmt.executeUpdate(SQL);

            return "funcionario inserido com sucesso!";
        } catch (SQLException error) {
            return "erro ao inserir o funcionario" + error;
        }
    }
    @Override
    public Funcionario selecionarFuncionario(int idFuncionario) {
        try {
            String SQL = "SELECT * FROM funcionario WHERE idfuncionario = " + Integer.toString(idFuncionario) + ";";
            ResultSet rs = stmt.executeQuery(SQL);

            if (rs.next()) {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("idfuncionario"));
                f.setIdUsuario(rs.getInt("idusuario"));
                f.setCargo(rs.getString("cargo"));
                return f;
            } else {
                return null; // Nenhum funcionario encontrado com o ID fornecido
            }
        } catch (SQLException error) {
            System.out.println("erro ao selecionar o funcionario" + error);
            return null;
        }
    }
    @Override
    public ArrayList<Funcionario> selecionarTodosFuncionarios() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM funcionario;";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("idfuncionario"));
                f.setIdUsuario(rs.getInt("idusuario"));
                f.setCargo(rs.getString("cargo"));
                funcionarios.add(f);
            }
        } catch (SQLException error) {
            System.out.println("erro ao selecionar todos os funcionarios" + error);
        }
        return funcionarios;
    }

    @Override
    public Funcionario verificarFuncionario(int idUsuario) {
        Funcionario f = new Funcionario();

        try {
            String SQL = "SELECT * FROM funcionario WHERE idusuario = " + idUsuario + ";";
            ResultSet rs = stmt.executeQuery(SQL);

            if (rs.next()) {
                f.setIdFuncionario(rs.getInt("idfuncionario"));
                f.setIdUsuario(rs.getInt("idusuario"));
                f.setCargo(rs.getString("cargo"));
            }
        } catch (SQLException error) {
            System.out.println("erro ao selecionar o funcionario" + error);
        }
        return f;

    }    
}
