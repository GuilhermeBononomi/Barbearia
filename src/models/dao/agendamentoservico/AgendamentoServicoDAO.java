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
                    "UPDATE agendamentoservico SET " +
                            "Observacao = '" + Observacao + "' " +
                            "WHERE idagendamento = " + Integer.toString(idAgendamento) + " AND idservico = " + Integer.toString(idServico) + ";";

            stmt.executeUpdate(SQL);

            return "agendamentoservico atualizado com sucesso!";
        } catch (SQLException error) {
            return "erro ao atualizar o agendamento_servico" + error;
        }
    }
    @Override
    public String deletarAgendamentoServico(int idAgendamento, int idServico) {
        try {
            String SQL = "DELETE FROM agendamentoservico WHERE idagendamento = " + Integer.toString(idAgendamento) + " AND idservico = " + Integer.toString(idServico) + ";";
            stmt.executeUpdate(SQL);
            return "agendamentoservico deletado com sucesso!";
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

            String SQL = "INSERT INTO agendamentoservico (idagendamento, idservico, Observacao) VALUES ("
                    + novo.getIdAgendamento() + ","
                    + novo.getIdServico() + ","
                    + "'" + novo.getObservacao() + "');";

            

            stmt.executeUpdate(SQL);

            return "agendamentoservico inserido com sucesso!";
        } catch (SQLException error) {
            return "erro ao inserir o agendamentoservico" + error;
        }
    }
    @Override
    public AgendamentoServico selecionarAgendamentoServico(int idAgendamento, int idServico) {
        try {
            String SQL = "SELECT * FROM agendamentoservico WHERE idagendamento = " + Integer.toString(idAgendamento) + " AND idservico = " + Integer.toString(idServico) + ";";
            ResultSet rs = stmt.executeQuery(SQL);

            AgendamentoServico agendamentoServico = new AgendamentoServico();

            while (rs.next()) {
                agendamentoServico.setIdAgendamento(rs.getInt("idagendamento"));
                agendamentoServico.setIdServico(rs.getInt("idservico"));
                agendamentoServico.setObservacao(rs.getString("Observacao"));
            }
            return agendamentoServico;
        } catch (SQLException error) {
            System.out.println("erro ao selecionar o agendamentoservico" + error);
            return null;
        }
    }
    @Override
    public ArrayList<AgendamentoServico> selecionarTodosAgendamentosServicos() {
        ArrayList<AgendamentoServico> lista = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM agendamentoservico;";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                AgendamentoServico agendamentoServico = new AgendamentoServico();
                agendamentoServico.setIdAgendamento(rs.getInt("idagendamento"));
                agendamentoServico.setIdServico(rs.getInt("idservico"));
                agendamentoServico.setObservacao(rs.getString("Observacao"));
                lista.add(agendamentoServico);
            }
        } catch (SQLException error) {
            System.out.println("erro ao selecionar todos os agendamentos_servicos" + error);
        }
        return lista;
    }

    @Override
    public ArrayList<AgendamentoDetalhado> buscarAgendamentoPorServico(String nome) {
        ArrayList<AgendamentoDetalhado> lista = new ArrayList<>();
        try {
            String sql = "SELECT a.data, a.inicio, a.termino, s.nome " +
                    "FROM agendamento AS a " +
                    "JOIN agendamentoservico AS ags ON a.idagendamento = ags.idagendamento " +
                    "JOIN servico AS s ON ags.idservico = s.idservico " +
                    "WHERE s.nome LIKE '%" + nome + "%';";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                AgendamentoDetalhado agendamentoDetalhado = new AgendamentoDetalhado();
                agendamentoDetalhado.setData(rs.getString("data"));
                agendamentoDetalhado.setInicio(rs.getString("inicio"));
                agendamentoDetalhado.setTermino(rs.getString("termino"));
                agendamentoDetalhado.setNomeServico(rs.getString("nome"));
                lista.add(agendamentoDetalhado);
            }
        } catch (SQLException error) {
            System.out.println("erro ao selecionar todos os agendamentos_servicos" + error);
        }
        return lista;
    }

}
