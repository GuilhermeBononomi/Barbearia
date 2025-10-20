import java.util.Scanner;

import controller.TelaCadastroController;
import controller.TelaUsuario;
import models.dao.usuario.Usuario;

public class App {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        TelaUsuario telaUsuario = new TelaUsuario();
        TelaCadastroController telaCadastroController = new TelaCadastroController();
        Usuario usuario = new Usuario();
        int opcoes = 0;
        
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
                usuario = telaUsuario.realizarLogin();
                System.out.println("Olá, " + usuario.getNome());
                break;
            case 3:
                
                break;
            default:
                break;
        }
    }
}