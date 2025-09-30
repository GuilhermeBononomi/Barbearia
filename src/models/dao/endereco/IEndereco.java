package models.dao.endereco;

import java.util.ArrayList;

public interface IEndereco {
  // SELECT
  public Endereco selecionarEndereco(int idEndereco);

  public ArrayList<Endereco> selecionarTodosEnderecos();

  // INSERT
  public String inserirEndereco(String rua, String bairro, int numero, String cep);

  // UPDATE
  public String atualizarEndereco(int idEndereco, String rua, String bairro, int numero, String cep);

  // DELETE
  public String deletarEndereco(int idEndereco);

}
