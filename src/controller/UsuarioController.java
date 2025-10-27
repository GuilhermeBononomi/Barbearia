package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.dao.agendamento.Agendamento;
import models.dao.agendamento.AgendamentoDAO;
import models.dao.usuario.*;

public class UsuarioController {
    private UsuarioDAO login = new UsuarioDAO();
    Scanner ler = new Scanner(System.in);
    Usuario usuario = new Usuario();
    ArrayList<Agendamento> agendamentos = new ArrayList<>();
    AgendamentoDAO agendamentoDAO = new AgendamentoDAO();


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

}
