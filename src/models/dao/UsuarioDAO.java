package models.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO implements IUsuario {
    ConexaoBanco conexao = new ConexaoBanco();
    Statement stmt = conexao.getStatement();

    public UsuarioDAO() {
    }

    @Override
    public String atualizarUsuario(int idUsuario, int idEndereco, String nome, String sobrenome, String dataNascimento, String email, String senha, String dataCriacao, String dataAlteracao, boolean status) {
        
        return null;
    }

    @Override
    public String deletarUsuario(int idUsuario) {
        
        return null;
    }

    @Override
    public String inserirUsuario(int idEndereco, String nome, String sobrenome, String dataNascimento, String email,
            String senha, String dataCriacao, String dataAlteracao, boolean status) {
        try {
            Usuario novo = new Usuario();
            novo.setIdEndereco(idEndereco);
            novo.setNome(nome);
            novo.setSobrenome(sobrenome);
            novo.setDataNascimento(dataNascimento);
            novo.setEmail(email);
            novo.setSenha(senha);
            novo.setDataCriacao(dataCriacao);
            novo.setDataAlteracao(dataAlteracao);
            novo.setStatus(status);

            String SQL = "INSERT INTO endereco (rua, bairro, numero, cep) VALUES ('"
                    + novo.getIdEndereco() + "','"
                    + novo.getNome() + "','"
                    + novo.getSobrenome() + "','"
                    + novo.getDataNascimento() + "','"
                    + novo.getEmail() + "','"
                    + novo.getSenha() + "','"
                    + novo.getDataCriacao() + "','"
                    + novo.getDataAlteracao() + "','"
                    + novo.isStatus() + "')";

            stmt.executeUpdate(SQL);

            return "endereço inserido com sucesso!";
        } catch (Exception error) {
            return error.getMessage();
        }
    }

    @Override
    public Usuario selecionarUsuario(int idUsuario) {
        Usuario usuario = new Usuario();

        try {
            String SQL = "SELECT * FROM usuario WHERE idusuario = " + idUsuario;

            ResultSet resultado = stmt.executeQuery(SQL);

            if (!resultado.wasNull()) {
                resultado.next();
                usuario.setIdUsuario(resultado.getInt("idUsuario"));
                usuario.setIdEndereco(resultado.getInt("idEndereco"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setSobrenome(resultado.getString("sobrenome"));
                usuario.setDataNascimento(resultado.getString("datanascimento"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setDataCriacao(resultado.getString("datacriacao"));
                usuario.setDataAlteracao(resultado.getString("dataalteracao"));
                usuario.setStatus(resultado.getBoolean("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public ArrayList<Usuario> selecionarTodosUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {

            String SQL = "SELECT * FROM usuario";

            ResultSet resultado = stmt.executeQuery(SQL);

            while (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultado.getInt("idUsuario"));
                usuario.setIdEndereco(resultado.getInt("idEndereco"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setSobrenome(resultado.getString("sobrenome"));
                usuario.setDataNascimento(resultado.getString("datanascimento"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setDataCriacao(resultado.getString("datacriacao"));
                usuario.setDataAlteracao(resultado.getString("dataalteracao"));
                usuario.setStatus(resultado.getBoolean("status"));
                lista.add(usuario);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

}
