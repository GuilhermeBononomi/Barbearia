package models.dao.usuario;

import java.util.ArrayList;

public interface IUsuario {
  // SELECT
  public Usuario selecionarUsuario(int idUsuario);

  public ArrayList<Usuario> selecionarTodosUsuarios();

  // INSERT
  public String inserirUsuario(int idEndereco, String nome, String sobrenome, String dataNascimento, String email, String senha, String dataCriacao, String dataAlteracao, boolean status);

  // UPDATE
  public String atualizarUsuario(int idUsuario, int idEndereco, String nome, String sobrenome, String dataNascimento, String email, String senha, String dataCriacao, String dataAlteracao, boolean status);

  // DELETE
  public String deletarUsuario(int idUsuario);

  // LOGIN
  public boolean buscarLogin(String email, String senha);

}
