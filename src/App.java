import models.dao.Endereco;
import models.dao.EnderecoDAO;

public class App {
    public static void main(String[] args) {
        EnderecoDAO endereco = new EnderecoDAO();
        Endereco end = new Endereco();
        // endereco.inserirEndereco("Rua A", "Bairro B", 123, "12345-678"); 

        end = endereco.selecionarEndereco(1);
        System.out.println(end.getBairro());
    }
}