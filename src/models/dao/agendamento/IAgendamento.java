package models.dao.agendamento;

import java.util.ArrayList;

public interface IAgendamento {
    //SELECT
    public Agendamento selecionarAgendamento(int idAgendamento);
    public Agendamento selecionarAgendamento(String data, String inicio, String termino);

    public ArrayList<Agendamento> selecionarTodosAgendamentos(int idUsuario);

    public ArrayList<Agendamento> buscarProximosAgendamentos(int idUsuario);
    //INSERT
    public String inserirAgendamento(int idUsuario, int idFuncionario, String data, String inicio, String termino);
    //UPDATE
    public String atualizarAgendamento(int idAgendamento, int idUsuario, int idFuncionario, String data, String inicio, String termino);
    //DELETE
    public String deletarAgendamento(int idAgendamento);
}
