package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UsuariosDAO {
    //Objeto para instanciar classe Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoUsuario = conndb.prepareStatement("INSERT INTO usuarios (nome, email, senha, cargo_id) VALUES (?, ?, md5(?), ?);");
            //Setar os parâmetros
            novoUsuario.setString(1, "Pamella");
            novoUsuario.setString(2, "pamellapereto@gmail.com");
            novoUsuario.setString(3, "123");
            novoUsuario.setInt(4, 1);
            int linhaAfetada = novoUsuario.executeUpdate();
            conndb.close(); //Encerrar conexão após inserção
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }

    public boolean alterarUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement usuarioAlterado  = conndb.prepareStatement("UPDATE usuarios SET nome = ?, email = ?, senha = md5(?) ,cargo_id = ? WHERE id = ?; ");
            usuarioAlterado.setString(1, "Pamella");
            usuarioAlterado.setString(2, "pamellapereto@gmail.com");
            usuarioAlterado.setString(3, "1234");
            usuarioAlterado.setInt(4, 1);//Alterar usuário c/ chave primária ID=1
            usuarioAlterado.setInt(5, 5);
            int linhaAfetada = usuarioAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao alterar usuario: " + erro);
            return false;
        }
    }

    public boolean deletarUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeUsuario = conndb.prepareStatement
                    ("DELETE FROM usuarios WHERE id = ?;");
            removeUsuario.setInt(1, 1);
            int linhaAfetada = removeUsuario.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar usuario: " + erro);
            return false;
        }
    }

    //Query SELECT
    public void pesquisarUsuario() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaUsuario = conndb.prepareStatement("SELECT nome, email FROM usuarios WHERE cargo_id  = ?");
            buscaUsuario.setInt(1, 1);
            ResultSet resultado = buscaUsuario.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                System.out.println("Nome: " + nome + " - Email: " + email);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario: " + erro);
        }
    }
}