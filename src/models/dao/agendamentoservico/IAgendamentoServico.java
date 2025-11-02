package models.dao.agendamentoservico;
import java.util.ArrayList;


public interface IAgendamentoServico {

    //SELECT
    public AgendamentoServico selecionarAgendamentoServico(int idAgendamento, int idServico);
    public ArrayList<AgendamentoServico> selecionarTodosAgendamentosServicos();
    //INSERT
    public String inserirAgendamentoServico(int idAgendamento, int idServico, String Observacao);
    //UPDATE
    public String atualizarAgendamentoServico(int idAgendamento, int idServico, String Observacao);
    //DELETE
    public String deletarAgendamentoServico(int idAgendamento, int idServico);

    public ArrayList<AgendamentoDetalhado> buscarAgendamentoPorServico(String nome, int idusuario);
}
