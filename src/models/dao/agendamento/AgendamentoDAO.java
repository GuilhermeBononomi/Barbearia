package models.dao.agendamento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.dao.ConexaoBanco;


public class AgendamentoDAO implements IAgendamento {
    ConexaoBanco conexao = new ConexaoBanco();
    Statement stmt = conexao.getStatement();

    public AgendamentoDAO() {
    }

    @Override
    public String atualizarAgendamento(int idAgendamento, int idUsuario, int idFuncionario, String data, String inicio, String termino) {
        try {
            String SQL =
                    "UPDATE agendamento SET " +
                            "id_usuario = " + Integer.toString(idUsuario) + ", " +
                            "id_funcionario = " + Integer.toString(idFuncionario) + ", " +
                            "data = '" + data + "', " +
                            "inicio = '" + inicio + "', " +
                            "termino = '" + termino + "' " +
                            "WHERE id_agendamento = " + Integer.toString(idAgendamento) + ";";

            stmt.executeUpdate(SQL);

            return "agendamento atualizado com sucesso!";
        } catch (SQLException error) {
            return "erro ao atualizar o agendamento" + error;
        }
    }

    @Override
    public String deletarAgendamento(int idAgendamento) {
        try {
            String SQL = "DELETE FROM agendamento WHERE id_agendamento = " + Integer.toString(idAgendamento) + ";";
            stmt.executeUpdate(SQL);
            return "agendamento deletado com sucesso!";
        } catch (SQLException error) {
            return "erro ao deletar o agendamento" + error;
        }
    }   

    @Override
    public String inserirAgendamento(int idUsuario, int idFuncionario, String data, String inicio, String termino) {
        try {
            Agendamento novo = new Agendamento();
            novo.setIdUsuario(idUsuario);
            novo.setIdFuncionario(idFuncionario);
            novo.setData(data);
            novo.setInicio(inicio);
            novo.setTermino(termino);

            String SQL = "INSERT INTO agendamento (id_usuario, id_funcionario, data, inicio, termino) VALUES ("
                    + novo.getIdUsuario() + ","
                    + novo.getIdFuncionario() + ",'"
                    + novo.getData() + "','"
                    + novo.getInicio() + "','"
                    + novo.getTermino() + "')";

            stmt.executeUpdate(SQL);

            return "agendamento inserido com sucesso!";
        } catch (SQLException error) {
            return "erro ao inserir o agendamento" + error;
        }
    }   

    @Override
    public Agendamento selecionarAgendamento(int idAgendamento) {
        Agendamento agendamento = new Agendamento();
        try {
            String SQL = "SELECT * FROM agendamento WHERE id_agendamento = " + Integer.toString(idAgendamento) + ";";
            ResultSet rs = stmt.executeQuery(SQL);
            if (rs.next()) {
                agendamento.setIdAgendamento(rs.getInt("id_agendamento"));
                agendamento.setIdUsuario(rs.getInt("id_usuario"));
                agendamento.setIdFuncionario(rs.getInt("id_funcionario"));
                agendamento.setData(rs.getString("data"));
                agendamento.setInicio(rs.getString("inicio"));
                agendamento.setTermino(rs.getString("termino"));
            }
        } catch (SQLException error) {
            System.out.println("erro ao selecionar o agendamento" + error);
        }
        return agendamento;
    }   

    @Override
    public ArrayList<Agendamento> selecionarTodosAgendamentos() {
        ArrayList<Agendamento> agendamentos = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM agendamento;";
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setIdAgendamento(rs.getInt("id_agendamento"));
                agendamento.setIdUsuario(rs.getInt("id_usuario"));
                agendamento.setIdFuncionario(rs.getInt("id_funcionario"));
                agendamento.setData(rs.getString("data"));
                agendamento.setInicio(rs.getString("inicio"));
                agendamento.setTermino(rs.getString("termino"));
                agendamentos.add(agendamento);
            }
        } catch (SQLException error) {
            System.out.println("erro ao selecionar todos os agendamentos" + error);
        }
        return agendamentos;
    }   
}
