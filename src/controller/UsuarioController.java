package controller;

import java.util.ArrayList;

import models.dao.agendamento.Agendamento;
import models.dao.agendamento.AgendamentoDAO;
import models.dao.funcionario.Funcionario;
import models.dao.funcionario.FuncionarioDAO;
import models.dao.agendamentoservico.AgendamentoDetalhado;
import models.dao.agendamentoservico.AgendamentoServicoDAO;
import models.dao.usuario.*;
import view.TelaAdministrador;
import view.TelaUsuario;

public class UsuarioController {


    private AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
    
    private AgendamentoServicoDAO agendamentoServicoDAO = new AgendamentoServicoDAO();

    private Usuario usuario = new Usuario();
    private UsuarioDAO login = new UsuarioDAO();

    private Funcionario colaborador = new Funcionario();
    private FuncionarioDAO colaboradorDAO = new FuncionarioDAO();

    private ArrayList<Agendamento> agendamentos = new ArrayList<>();
    private ArrayList<AgendamentoDetalhado> agendamentoDetalhado = new ArrayList<>();

    int id_servico = 1;

    public UsuarioController() {
    }

    public Usuario validarLogin(String email, String senha) {
        usuario = login.buscarLogin(email, senha);
        return usuario;
    }

    public void verificaFuncionario(int idUsuario, Usuario usuarioLogado) {
        colaborador = colaboradorDAO.verificarFuncionario(idUsuario);
        if (colaborador.getCargo() != null) {
            new TelaAdministrador();
        } else {
            new TelaUsuario(usuarioLogado);
        }
    }

    public void buscarProximosAgendamentos(int idUsuario) {
        agendamentos = agendamentoDAO.buscarProximosAgendamentos(idUsuario);
        if (!agendamentos.isEmpty()) {
            System.out.println("\nPróximos Agendamentos:");
            for (Agendamento agenda : agendamentos) {
                System.out.println("\nData agendamento: " + agenda.getData());
                System.out.println("Hora Início: " + agenda.getInicio());
                System.out.println("Hora Término: " + agenda.getTermino());
            }
        } else {
            System.out.println("\nNenhum agendamento marcado encontrado!");
        }
    }

    public void selecionarTodosAgendamentos(int idUsuario) {
        agendamentos = agendamentoDAO.selecionarTodosAgendamentos(idUsuario);
        if (!agendamentos.isEmpty()) {
            System.out.println("\nHistórico de agendamentos:");
            for (Agendamento agenda : agendamentos) {
                System.out.println("\nData agendamento: " + agenda.getData());
                System.out.println("Hora Início: " + agenda.getInicio());
                System.out.println("Hora Término: " + agenda.getTermino());
            }
        } else {
            System.out.println("\nNenhum agendamento encontrado!");
        }
    }

    public void buscarAgendamentosPorServico(String nome, int idusuario) {
        agendamentoDetalhado = agendamentoServicoDAO.buscarAgendamentoPorServico(nome, idusuario);
        if (!agendamentoDetalhado.isEmpty()) {
            System.out.println("\nAgendamentos de serviço que contenham: '" + nome + "':");
            for (AgendamentoDetalhado agenda : agendamentoDetalhado) {
                System.out.println("\nData agendamento: " + agenda.getData());
                System.out.println("Hora Início: " + agenda.getInicio());
                System.out.println("Hora Término: " + agenda.getTermino());
                System.out.println("Serviço: " + agenda.getNomeServico());
            }
        } else {
            System.out.println("\nNenhum agendamento encontrado!");
        }
    }

    public void cadastrarAgendamento(String email, String senha, int servico, int funcionario, String data, String inicio, String termino, String observacao) {
        Agendamento agendamento = new Agendamento();
        try {
            usuario = login.buscarLogin(email, senha);

            colaborador = colaboradorDAO.selecionarFuncionario(funcionario);

            agendamentoDAO.inserirAgendamento(usuario.getIdUsuario(), colaborador.getIdFuncionario(), data, inicio, termino);

            agendamento = agendamentoDAO.selecionarAgendamento(data, inicio, termino);

            agendamentoServicoDAO.inserirAgendamentoServico(agendamento.getIdAgendamento(), servico, observacao);
        } catch (Exception error) {
            error.getMessage();
        } finally {
            System.out.println("Agendamento criado com sucesso!");
        }
    }

}
