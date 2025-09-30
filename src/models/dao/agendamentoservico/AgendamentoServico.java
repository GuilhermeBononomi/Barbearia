package models.dao.agendamentoservico;
//idAgendamento, idServico e Observacao
public class AgendamentoServico {
    private int idAgendamento;
    private int idServico;
    private String Observacao;

    public AgendamentoServico() {
    }
    public int getIdAgendamento() {
        return idAgendamento;
    }
    protected void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }
    public int getIdServico() {
        return idServico;
    }
    protected void setIdServico(int idServico) {
        this.idServico = idServico;
    }
    public String getObservacao() {
        return Observacao;
    }
    protected void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }
}
