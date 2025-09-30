package models.dao.agendamento;
// IdAgendamento, IdUsuario, idFuncionario, Data, Inicio e termino
public class Agendamento {
    private int idAgendamento;
    private int idUsuario;
    private int idFuncionario;
    private String Data;
    private String Inicio;
    private String Termino;

    public Agendamento() {
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }
    protected void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    protected void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getIdFuncionario() {
        return idFuncionario;
    }
    protected void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public String getData() {
        return Data;
    }
    protected void setData(String data) {
        Data = data;
    }
    public String getInicio() {
        return Inicio;
    }
    protected void setInicio(String inicio) {
        Inicio = inicio;
    }
    public String getTermino() {
        return Termino;
    }
    protected void setTermino(String termino) {
        Termino = termino;
    }

}
