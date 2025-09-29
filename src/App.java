import models.dao.EnderecoDAO;

public class App {
    public static void main(String[] args) {
        EnderecoDAO endereco = new EnderecoDAO();
        endereco.inserirEndereco("Rua A", "Bairro B", 123, "12345-678"); 
    }
}
