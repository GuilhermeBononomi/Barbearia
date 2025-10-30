package models.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import org.flywaydb.core.Flyway;

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

      // Executar migrations do Flyway
      runMigrations();

      System.out.println("Conectado ao banco: " + database);
    } catch (SQLException | ClassNotFoundException error) {
      error.printStackTrace();
    }
  }

  public Connection getConnection() {
    return connection;
  }

  public Statement getStatement() {
    return this.stmt;
  }

  /**
   * Executa as migrations do banco de dados usando Flyway
   */
  private void runMigrations() {
    try {
      String url = "jdbc:postgresql://localhost:5432/" + database;
      
      Flyway flyway = Flyway.configure()
          .dataSource(url, user, password)
          .locations("filesystem:src/main/resources/db/migration")
          .load();
      
      flyway.migrate();
      
      System.out.println("Migrations executadas com sucesso!");
    } catch (Exception e) {
      System.err.println("Erro ao executar migrations: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
