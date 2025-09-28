package models.dao;

public class Endereco {
  private int idEndereco;
  private String rua;
  private String bairro;
  private int numero;
  private String cep;

  public Endereco() {}

  protected int getIdEndereco() {
    return idEndereco;
  }

  protected String getRua() {
    return rua;
  }

  protected String getBairro() {
    return bairro;
  }

  protected int getNumero() {
    return numero;
  }

  protected String getCep() {
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
