package models.dao.agendamentoservico;

import java.sql.Statement;
import java.util.ArrayList;

import models.dao.ConexaoBanco;

import java.sql.SQLException;
import java.sql.ResultSet;



public class AgendamentoServicoDAO implements IAgendamentoServico {
    ConexaoBanco conexao = new ConexaoBanco();
    Statement stmt = conexao.getStatement();

    public AgendamentoServicoDAO() {
    }

    @Override
    public String atualizarAgendamentoServico(int idAgendamento, int idServico, String Observacao) {
        try {
            String SQL =
                    "UPDATE agendamento_servico SET " +
                            "Observacao = '" + Observacao + "' " +
                            "WHERE id_agendamento = " + Integer.toString(idAgendamento) + " AND id_servico = " + Integer.toString(idServico) + ";";

            stmt.executeUpdate(SQL);

            return "agendamento_servico atualizado com sucesso!";
        } catch (SQLException error) {
            return "erro ao atualizar o agendamento_servico" + error;
        }
    }
    @Override
    public String deletarAgendamentoServico(int idAgendamento, int idServico) {
        try {
            String SQL = "DELETE FROM agendamento_servico WHERE id_agendamento = " + Integer.toString(idAgendamento) + " AND id_servico = " + Integer.toString(idServico) + ";";
            stmt.executeUpdate(SQL);
            return "agendamento_servico deletado com sucesso!";
        } catch (SQLException error) {
            return "erro ao deletar o agendamento_servico" + error;
        }
    }
    @Override
    public String inserirAgendamentoServico(int idAgendamento, int idServico, String Observacao) {
        try {
            AgendamentoServico novo = new AgendamentoServico();
            novo.setIdAgendamento(idAgendamento);
            novo.setIdServico(idServico);
            novo.setObservacao(Observacao);

            String SQL = "INSERT INTO agendamento_servico (id_agendamento, id_servico, Observacao) VALUES ("
                    + novo.getIdAgendamento() + ","
                    + novo.getIdServico() + ","
                    + "'" + novo.getObservacao() + "');";

            

            stmt.executeUpdate(SQL);

            return "agendamento_servico inserido com sucesso!";
        } catch (SQLException error) {
            return "erro ao inserir o agendamento_servico" + error;
        }
    }
    @Override
    public AgendamentoServico selecionarAgendamentoServico(int idAgendamento, int idServico) {
        try {
            String SQL = "SELECT * FROM agendamento_servico WHERE id_agendamento = " + Integer.toString(idAgendamento) + " AND id_servico = " + Integer.toString(idServico) + ";";
            ResultSet rs = stmt.executeQuery(SQL);

            AgendamentoServico agendamentoServico = new AgendamentoServico();

            while (rs.next()) {
                agendamentoServico.setIdAgendamento(rs.getInt("id_agendamento"));
                agendamentoServico.setIdServico(rs.getInt("id_servico"));
                agendamentoServico.setObservacao(rs.getString("Observacao"));
            }
            return agendamentoServico;
        } catch (SQLException error) {
            System.out.println("erro ao selecionar o agendamento_servico" + error);
            return null;
        }
    }
    @Override
    public ArrayList<AgendamentoServico> selecionarTodosAgendamentosServicos() {
        ArrayList<AgendamentoServico> lista = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM agendamento_servico;";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                AgendamentoServico agendamentoServico = new AgendamentoServico();
                agendamentoServico.setIdAgendamento(rs.getInt("id_agendamento"));
                agendamentoServico.setIdServico(rs.getInt("id_servico"));
                agendamentoServico.setObservacao(rs.getString("Observacao"));
                lista.add(agendamentoServico);
            }
        } catch (SQLException error) {
            System.out.println("erro ao selecionar todos os agendamentos_servicos" + error);
        }
        return lista;
    }

}
