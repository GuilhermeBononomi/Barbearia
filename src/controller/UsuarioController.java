package controller;

import java.util.Scanner;

import models.dao.usuario.*;

public class UsuarioController {
    private UsuarioDAO login = new UsuarioDAO();
    Scanner ler = new Scanner(System.in);
    Usuario usuario = new Usuario();


    public UsuarioController() {
    }

    public Usuario validarLogin(String email, String senha) {
        usuario = login.buscarLogin(email, senha);
        return usuario;
        
    }

}
