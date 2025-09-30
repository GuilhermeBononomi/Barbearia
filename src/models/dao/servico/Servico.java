package models.dao.servico;

public class Servico {
  private int idServico;
  private String nome;
  private double preco;
  private String descricao;

  public int getIdServico() {
    return idServico;
  }
  public String getNome() {
    return nome;
  }
  public double getPreco() {
    return preco;
  }
  public String getDescricao() {
    return descricao;
  }
  public void setIdServico(int idServico) {
    this.idServico = idServico;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public void setPreco(double preco) {
    this.preco = preco;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
