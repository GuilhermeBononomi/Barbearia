import java.util.ArrayList;
import java.util.Scanner;

import controller.TelaCadastroController;
import controller.UsuarioController;
import models.dao.agendamento.Agendamento;
import models.dao.agendamento.AgendamentoDAO;
import models.dao.endereco.EnderecoDAO;
import models.dao.funcionario.FuncionarioDAO;
import models.dao.usuario.Usuario;
import models.dao.usuario.UsuarioDAO;

public class App {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        UsuarioController telaUsuario = new UsuarioController();
        Usuario usuario = new Usuario();
        ArrayList<Agendamento> agendamentos = new ArrayList<>();
        TelaCadastroController telaCadastroController = new TelaCadastroController();

        UsuarioDAO daousuario = new UsuarioDAO();
        EnderecoDAO daoendereco = new EnderecoDAO();
        FuncionarioDAO daofuncionario = new FuncionarioDAO();
        AgendamentoDAO daoagendamento = new AgendamentoDAO();

        int opcoes = 0;
        boolean validaErro;
        String email = "";
        String senha = "";

        // daoendereco.inserirEndereco("Rua", "Bairro", 10, "8989880");
        // email = daousuario.inserirUsuario(2, "Pamonha", "pamonha", "2005-01-10", "473856765", 
        // "47991589990", "pamo@a.com", "123", "2025-09-21", "2025-09-21", true);

        // daofuncionario.inserirFuncionario(2, "Barbeiro");

        // daoagendamento.inserirAgendamento(1, 1, "2025-10-18", "10:45", "11:20");
        
        System.out.println("=======================================================");
        System.out.println("=                    Seja Bem Vindo                   =");
        System.out.println("=======================================================");
        do {
            System.out.println("\nSelecione uma das opções para começar a usar nosso aplicativo:");
            System.out.println("1. Fazer novo Cadastro");
            System.out.println("2. Fazer Login - Usuário");
            System.out.println("3. Fazer Login - Administrativo");
            System.out.println("0. Sair");
            opcoes = ler.nextInt();
        } while (opcoes < 0 || opcoes > 3);

        switch (opcoes) {
            case 0:
                System.out.println("Volte Sempre");
                System.exit(0);
                break;
            case 1:
                telaCadastroController.IniciarCadastro();
                break;
            case 2:
                System.out.println();
                System.out.println("=======================================================");
                System.out.println("=                    Seja Bem Vindo                   =");
                System.out.println("=======================================================");
                do {
                    System.out.println("\nFaça seu Login");
                    System.out.println("Informe seu Email:");
                    email = ler.next();
                    System.out.println("\nInforme sua Senha:");
                    senha = ler.next();
                    usuario = telaUsuario.validarLogin(email, senha);
                    if (usuario.getNome() != null) {
                        System.out.println("\nLogin efetuado com sucesso!");
                        validaErro = false;
                    } else {
                        System.out.println("Erro ao efetuar o login!");
                        System.out.println("Tente novamente!\n");
                        validaErro = true;
                    }
                } while (validaErro);
                System.out.println("Olá, " + usuario.getNome());
                
                do {
                    System.out.println("\nSelecione a opção que deseja realizar:");
                    System.out.println("1. Fazer novo agendamento");
                    System.out.println("2. Ver próximos agendamentos");
                    System.out.println("3. Ver histórico de agendamentos");
                    System.out.println("0. Sair");
                    opcoes = ler.nextInt();

                    switch (opcoes) {
                    case 0:
                        System.out.println("Volte Sempre");
                        System.exit(0);
                        break;
                    case 1:

                        break;
                    case 2:
                        agendamentos = telaUsuario.buscarProximosAgendamentos(usuario.getIdUsuario());
                        if (agendamentos != null) {
                            System.out.println("Próximos Agendamentos:");
                            for (Agendamento agenda : agendamentos) {
                                System.out.println("\nData agendamento: " + agenda.getData());
                                System.out.println("Hora Início: " + agenda.getInicio());
                                System.out.println("Hora Término: " + agenda.getTermino());
                            }
                        } else {
                            System.out.println("Nenhum agendamento marcado encontrado!");
                        }
                        break;
                    case 3:
                        agendamentos = telaUsuario.selecionarTodosAgendamentos(usuario.getIdUsuario());
                        if (agendamentos != null) {
                            System.out.println("Histórico de agendamentos:");
                            for (Agendamento agenda : agendamentos) {
                                System.out.println("\nData agendamento: " + agenda.getData());
                                System.out.println("Hora Início: " + agenda.getInicio());
                                System.out.println("Hora Término: " + agenda.getTermino());
                            }
                        } else {
                            System.out.println("Nenhum agendamento encontrado!");
                        }
                        break;
                    default:
                        break;
                    }

                } while (opcoes >= 0 || opcoes <= 3);

                

                break;
            case 3:
                
                break;
            default:
                break;
        }
    }
}