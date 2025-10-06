package controller;

import java.util.Scanner;

import models.dao.usuario.*;

public class TelaUsuario {
    private UsuarioDAO login = new UsuarioDAO();
    Scanner ler = new Scanner(System.in);
    Usuario usuario = new Usuario();


    public TelaUsuario() {
    }

    public Usuario realizarLogin() {
        String email = "";
        String senha = "";
        boolean erroLogin = true;
        System.out.println("Bem Vindo");
        do {
            System.out.println("\nFaça seu Login");
            System.out.println("Informe seu Email:");
            email = ler.nextLine();
            System.out.println("\nInforme sua Senha:");
            senha = ler.nextLine();
            if (validarLogin(email, senha) != null) {
                System.out.println("Login efetuado com sucesso!");
                erroLogin = false;
            } else {
                System.out.println("Erro ao efetuar o login!");
                System.out.println("Tente novamente!");
                erroLogin = true;

            }
        } while (erroLogin);
        return usuario;
    }

    public Usuario validarLogin(String email, String senha) {
        usuario = login.buscarLogin(email, senha);
        if(usuario != null) {
            return usuario;
        }
        return null;
    }

}
