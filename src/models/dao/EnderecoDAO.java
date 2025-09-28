package models.dao;

import java.sql.SQLException;
import java.sql.Statement;

public class EnderecoDAO {
  ConexaoBanco conexao = new ConexaoBanco();
  Statement stmt = conexao.getStatement();

  public String criarTabelaEndereco() {
    try {
      String sql =
      "CREATE TABLE IF NOT EXISTS endereco (" +
      "idEndereco INT AUTO_INCREMENT PRIMARY KEY," +
      "rua VARCHAR(100) NOT NULL," +
      "bairro VARCHAR(100) NOT NULL," +
      "numero INT NOT NULL," +
      "cep VARCHAR(20) NOT NULL" +
      ")";

      stmt.execute(sql);

      return "table created!";
    } catch (SQLException error) {
      return error.getMessage();
    }
  }

}
