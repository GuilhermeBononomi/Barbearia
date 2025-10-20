package models.dao.usuario;

public class Usuario {
    private int idUsuario;
    private int idEndereco;
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;
    private String dataCriacao;
    private String dataAlteracao;
    private boolean status;

    public Usuario() {
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    protected void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getIdEndereco() {
        return idEndereco;
    }
    protected void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
    public String getNome() {
        return nome;
    }
    protected void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    protected void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    protected void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getCpf(){
        return cpf;
    }
    protected void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getTelefone(){
        return telefone;
    }
    protected void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    protected void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    protected void setSenha(String senha) {
        this.senha = senha;
    }
    public String getDataCriacao() {
        return dataCriacao;
    }
    protected void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public String getDataAlteracao() {
        return dataAlteracao;
    }
    protected void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
    public boolean isStatus() {
        return status;
    }
    protected void setStatus(boolean status) {
        this.status = status;
    }

}
