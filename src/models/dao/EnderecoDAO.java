package models.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EnderecoDAO implements IEndereco {
  ConexaoBanco conexao = new ConexaoBanco();
  Statement stmt = conexao.getStatement();

  public EnderecoDAO() {
  }

  @Override
  public String atualizarEndereco(int idEndereco, String rua, String bairro, int numero, String cep){
    try {
      String SQL =
      "UPDATE endereco SET " +
      "rua = '" + rua + "', " +
      "bairro = '" + bairro + "', " +
      "numero = " + Integer.toString(numero) + ", " +
      "cep = '" + cep + "' " +
      "WHERE id_endereco = " + Integer.toString(idEndereco) + ";";

      System.out.println(SQL);

      stmt.executeUpdate(SQL);

      return "endereço atualizado com sucesso!";
    } catch (SQLException error) {
      return "erro ao atualizar o endereço" + error;
    }
  }

  @Override
  public String deletarEndereco(int idEndereco) {
    try {
      String SQL = "DELETE FROM endereco WHERE idendereco = " + Integer.toString(idEndereco) + ";";
      stmt.executeUpdate(SQL);
      return "endereço deletado com sucesso!";
    } catch (SQLException error) {
      return "erro ao deletar o endereço" + error;
    }
  }

  @Override
  public String inserirEndereco(String rua, String bairro, int numero, String cep) {
    try {
      Endereco novo = new Endereco();
      novo.setRua(rua);
      novo.setBairro(bairro);
      novo.setNumero(numero);
      novo.setCep(cep);

      String SQL = "INSERT INTO endereco (rua, bairro, numero, cep) VALUES ('"
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
    Endereco endereco = new Endereco();

    try {
      String SQL = "SELECT * FROM endereco WHERE idendereco = " + idEndereco;

      ResultSet resultado = stmt.executeQuery(SQL);

      if (!resultado.wasNull()) {
        resultado.next();
        endereco.setBairro(resultado.getString("bairro"));
        endereco.setCep(resultado.getString("cep"));
        endereco.setRua(resultado.getString("rua"));
        endereco.setNumero(resultado.getInt("numero"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return endereco;
  }

  @Override
  public ArrayList<Endereco> selecionarTodosEnderecos() {
    ArrayList<Endereco> lista = new ArrayList<>();
    try {

      String SQL = "SELECT * FROM endereco";

      ResultSet resultado = stmt.executeQuery(SQL);

      while (resultado.next()) {
        Endereco endereco = new Endereco();
        endereco.setBairro(resultado.getString("bairro"));
        endereco.setCep(resultado.getString("cep"));
        endereco.setRua(resultado.getString("rua"));
        endereco.setNumero(resultado.getInt("numero"));
        lista.add(endereco);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return lista;
  }

}
