package models.dao;

import java.util.ArrayList;

public interface IEndereco {
  // SELECT
  public Endereco selecionarEndereco(int idEndereco);

  public ArrayList<Endereco> selecionarTodosEnderecos();

  // INSERT
  public String inserirEndereco(Endereco endereco);

  // UPDATE
  public String atualizarEndereco(Endereco endereco);

  // DELETE
  public String deletarEndereco(int idEndereco);

}
