package models.dao.servico;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.dao.ConexaoBanco;

public class ServicoDAO implements IServico{
  ConexaoBanco conexao = new ConexaoBanco();
  Statement stmt = conexao.getStatement();
  
  public ServicoDAO() {
  }

  @Override
  public String atualizarServico(int idServico, String nome, double preco, String descricao) {
    try {
      String SQL =
      "UPDATE servico SET " +
      "Nome = '" + nome + "', " +
      "Preco = '" + preco + "', " +
      "Descricao = '" + descricao + "' " +
      "WHERE idServico = " + Integer.toString(idServico) + ";";

      stmt.executeUpdate(SQL);
      
      return "servico atualizado com sucesso!";
    } catch (SQLException error) {
      return "erro ao atualizar o servico" + error;
    }
  }

  @Override
  public String deletarServico(int idServico) {
    try {
      String SQL = "DELETE FROM servico WHERE idServico = " + Integer.toString(idServico) + ";";
      stmt.executeUpdate(SQL);
      return "servico deletado com sucesso!";
    } catch (SQLException error) {
      return "erro ao deletar o servico" + error;
    }
  }

  @Override
  public String inserirServico(String nome, double preco, String descricao) {
    try {
      Servico servico = new Servico();
      servico.setNome(nome);
      servico.setPreco(preco);
      servico.setDescricao(descricao);

      String SQL =
      "INSERT INTO servico (Nome, Preco, Descricao) VALUES ('"
      + servico.getNome() + "','"
      + servico.getPreco() + "','"
      + servico.getDescricao() + "')";
      
      stmt.executeUpdate(SQL);
      
      return "servico inserido com sucesso!";
    } catch (SQLException error) {
      return "erro ao inserir o servico" + error;
    }
  }

  @Override
  public Servico selecionarServico(int idServico) {
    Servico servico = new Servico();
    try {
      String SQL = "SELECT * FROM servico WHERE idServico = " + Integer.toString(idServico) + ";";
      ResultSet resultado = stmt.executeQuery(SQL);

      if (!resultado.wasNull()) {
        resultado.next();
        servico.setNome(resultado.getString("Nome"));
        servico.setPreco(resultado.getDouble("Preco"));
        servico.setDescricao(resultado.getString("Descricao"));
      }
    } catch (SQLException error) {
      error.getMessage();
    }
    return servico;
  }

  @Override
  public ArrayList<Servico> selecionarTodosServicos() {
    ArrayList<Servico> lista = new ArrayList<>();
    try {
      String SQL = "SELECT * FROM servico";
      ResultSet resultado = stmt.executeQuery(SQL);

      while (resultado.next()) {
        Servico servico = new Servico();
        servico.setNome(resultado.getString("Nome"));
        servico.setPreco(resultado.getDouble("Preco"));
        servico.setDescricao(resultado.getString("Descricao"));
        lista.add(servico);
      }
    } catch (SQLException error) {
      error.getMessage();
    }
    return lista;
  }
}
