package models.dao;

import java.sql.Statement;
import java.util.ArrayList;

public class EnderecoDAO implements IEndereco {
  ConexaoBanco conexao = new ConexaoBanco();
  Statement stmt = conexao.getStatement();

  public EnderecoDAO() {
  }

  @Override
  public String atualizarEndereco(Endereco endereco) {
    return null;
  }

  @Override
  public String deletarEndereco(int idEndereco) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String inserirEndereco(String rua, String bairro, int numero, String cep) {
    try {
      Endereco novo = new Endereco();
      novo.setRua(rua);
      novo.setBairro(bairro);
      novo.setNumero(numero);
      novo.setCep(cep);

      String SQL =
      "INSERT INTO endereco (rua, bairro, numero, cep) VALUES ('"
      + novo.getRua() + "','" 
      + novo.getBairro() + "','" 
      + novo.getNumero() + "','" 
      + novo.getCep() + "')";

      stmt.executeUpdate(SQL);

      return "endereço inserido com sucesso!";
    } catch (Exception error) {
      return error.getMessage();
    }
  }

  @Override
  public Endereco selecionarEndereco(int idEndereco) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<Endereco> selecionarTodosEnderecos() {
    // TODO Auto-generated method stub
    return null;
  }

}
