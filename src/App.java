import models.dao.EnderecoDAO;

public class App {
    public static void main(String[] args) {
        EnderecoDAO table = new EnderecoDAO();
        table.criarTabelaEndereco();
    }
}
