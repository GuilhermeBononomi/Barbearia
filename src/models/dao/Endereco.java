package models.dao;

public class Endereco {
  private int idEndereco;
  private String rua;
  private String bairro;
  private int numero;
  private String cep;

  public Endereco() { }

  public int getIdEndereco() {
    return idEndereco;
  }

  public String getRua() {
    return rua;
  }

  public String getBairro() {
    return bairro;
  }

  public int getNumero() {
    return numero;
  }

  public String getCep() {
    return cep;
  }

  protected void setIdEndereco(int idEndereco) {
    this.idEndereco = idEndereco;
  }

  protected void setRua(String rua) {
    this.rua = rua;
  }

  protected void setBairro(String bairro) {
    this.bairro = bairro;
  }

  protected void setNumero(int numero) {
    this.numero = numero;
  }

  protected void setCep(String cep) {
    this.cep = cep;
  }
}
