package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import models.dao.agendamento.Agendamento;
import models.dao.agendamento.AgendamentoDAO;
import models.dao.agendamentoservico.AgendamentoDetalhado;
import models.dao.agendamentoservico.AgendamentoServicoDAO;
import models.dao.funcionario.Funcionario;
import models.dao.funcionario.FuncionarioDAO;
import models.dao.usuario.*;

public class UsuarioController {

    private AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
    private AgendamentoServicoDAO agendamentoServicoDAO = new AgendamentoServicoDAO();

    private Usuario usuario = new Usuario();
    private UsuarioDAO login = new UsuarioDAO();

    private Funcionario colaborador = new Funcionario();
    private FuncionarioDAO colaboradorDAO = new FuncionarioDAO();

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

    public void cadastrarAgendamento(String email, String senha, int funcionario, String data, String inicio, String termino) {
        try {
            usuario = login.buscarLogin(email, senha);

            colaborador = colaboradorDAO.selecionarFuncionario(funcionario);

            if (colaborador == null) {
                throw new SQLException();
            }

            agendamentoDAO.inserirAgendamento(usuario.getIdUsuario(), colaborador.getIdFuncionario(), data, inicio, termino);
        } catch (Exception error) {
            error.getMessage();
        } finally {
            System.out.println("Agendamento criado com sucesso!");
        }
    }

}
