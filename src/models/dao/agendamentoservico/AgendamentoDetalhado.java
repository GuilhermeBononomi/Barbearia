package models.dao.agendamentoservico;

public class AgendamentoDetalhado {

    private String data;
    private String inicio;
    private String termino;
    private String nomeServico;

    public AgendamentoDetalhado() {
    }

    public String getData() {
        return data;
    }

    public String getInicio() {
        return inicio;
    }

    public String getTermino() {
        return termino;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }
}
