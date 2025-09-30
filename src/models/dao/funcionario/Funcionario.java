package models.dao.funcionario;
//idFuncionario, idUsuario, Cargo
public class Funcionario {
    private int idFuncionario;
    private int idUsuario;
    private String Cargo;

    public Funcionario() {
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }   
    protected void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    protected void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getCargo() {
        return Cargo;
    }
    protected void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

}
