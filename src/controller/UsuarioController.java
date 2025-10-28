package controller;

import java.util.ArrayList;

import models.dao.agendamento.Agendamento;
import models.dao.agendamento.AgendamentoDAO;
import models.dao.agendamentoservico.AgendamentoDetalhado;
import models.dao.agendamentoservico.AgendamentoServicoDAO;
import models.dao.usuario.*;

public class UsuarioController {

    private UsuarioDAO login = new UsuarioDAO();
    private AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
    private AgendamentoServicoDAO agendamentoServicoDAO = new AgendamentoServicoDAO();

    private Usuario usuario = new Usuario();

    private ArrayList<Agendamento> agendamentos = new ArrayList<>();
    private ArrayList<AgendamentoDetalhado> agendamentoDetalhado = new ArrayList<>();



    public UsuarioController() {
    }

    public Usuario validarLogin(String email, String senha) {
        usuario = login.buscarLogin(email, senha);
        return usuario;
    }

    public ArrayList<Agendamento> buscarProximosAgendamentos(int idUsuario) {
        agendamentos = agendamentoDAO.buscarProximosAgendamentos(idUsuario);
        return agendamentos;
    }

    public ArrayList<Agendamento> selecionarTodosAgendamentos(int idUsuario) {
        agendamentos = agendamentoDAO.selecionarTodosAgendamentos(idUsuario);
        return agendamentos;
    }

    public ArrayList<AgendamentoDetalhado> buscarAgendamentosPorServico(String nome) {
        agendamentoDetalhado = agendamentoServicoDAO.buscarAgendamentoPorServico(nome);
        return agendamentoDetalhado;
    }

}
