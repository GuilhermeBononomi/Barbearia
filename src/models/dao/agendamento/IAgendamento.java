package models.dao.agendamento;

import java.util.ArrayList;

public interface IAgendamento {
    //SELECT
    public Agendamento selecionarAgendamento(int idAgendamento);

    public ArrayList<Agendamento> selecionarTodosAgendamentos();
    //INSERT
    public String inserirAgendamento(int idUsuario, int idFuncionario, String data, String inicio, String termino);
    //UPDATE
    public String atualizarAgendamento(int idAgendamento, int idUsuario, int idFuncionario, String data, String inicio, String termino);
    //DELETE
    public String deletarAgendamento(int idAgendamento);
}
