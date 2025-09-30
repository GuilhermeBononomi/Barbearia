package models.dao.funcionario;
import java.util.ArrayList;


public interface IFuncionario {
    //SELECT
    public Funcionario selecionarFuncionario(int idFuncionario);

    public ArrayList<Funcionario> selecionarTodosFuncionarios();
    //INSERT
    public String inserirFuncionario(int idUsuario, String cargo);
    //UPDATE
    public String atualizarFuncionario(int idFuncionario, int idUsuario, String cargo);
    //DELETE
    public String deletarFuncionario(int idFuncionario);

}
