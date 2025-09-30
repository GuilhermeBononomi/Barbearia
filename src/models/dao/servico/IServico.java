package models.dao.servico;

import java.util.ArrayList;

public interface IServico {
  // SELECT
  public Servico selecionarServico(int idServico);
  public ArrayList<Servico> selecionarTodosServicos();
  // INSERT
  public String inserirServico(String nome, double preco, String descricao);
  // UPDATE
  public String atualizarServico(int idServico, String nome, double preco, String descricao);
  // DELETE
  public String deletarServico(int idServico);
}
