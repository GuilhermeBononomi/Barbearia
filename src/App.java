import java.util.Scanner;

import controller.TelaCadastroController;
import controller.UsuarioController;
import models.dao.endereco.EnderecoDAO;
import models.dao.usuario.Usuario;
import models.dao.usuario.UsuarioDAO;

public class App {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        UsuarioController telaUsuario = new UsuarioController();
        Usuario usuario = new Usuario();

        UsuarioDAO daousuario = new UsuarioDAO();
        EnderecoDAO daoendereco = new EnderecoDAO();

        TelaCadastroController telaCadastroController = new TelaCadastroController();

        int opcoes = 0;
        boolean validaErro;
        String email = "";
        String senha = "";
        
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

                System.out.println("Selecione a opção que deseja realizar:");
                System.out.println("1. Fazer novo agendamento");
                System.out.println("2. Ver próximos agendamentos");

                break;
            case 3:
                
                break;
            default:
                break;
        }
    }
}