package models.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class ConexaoBanco {
  private Connection connection = null;
  private Statement stmt = null;

  private String user = "barbearia";
  private String password = "barbearia";
  private String database = "barbearia";

  public ConexaoBanco() {
    try {
      Class.forName("org.postgresql.Driver");

      this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + database, user, password);
      this.stmt = this.connection.createStatement();

      System.out.println("Conectado ao banco: " + database);
    } catch (ClassNotFoundException | SQLException error) {
      error.getMessage();
    }
  }

  public Connection getConnection() {
    return connection;
  }

  public Statement getStatement() {
    return this.stmt;
  }
}
