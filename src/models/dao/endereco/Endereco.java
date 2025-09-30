package models.dao.endereco;

public class Endereco {
  private int idEndereco;
  private String rua;
  private String bairro;
  private int numero;
  private String cep;

  public Endereco() {
  }

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

  public void setIdEndereco(int idEndereco) {
    this.idEndereco = idEndereco;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }
}
