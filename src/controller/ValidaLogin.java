package controller;

import models.dao.usuario.UsuarioDAO;

public class ValidaLogin {
    private UsuarioDAO login = new UsuarioDAO();

    public ValidaLogin() {
    }

    public boolean validarLogin(String email, String senha) {
        if(login.buscarLogin(email, senha)) {
            return true;
        } else {
            return false;
        }
    }
}
