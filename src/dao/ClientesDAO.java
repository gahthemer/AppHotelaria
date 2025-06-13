package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientesDAO {
    //Objeto para instanciar classe Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirClientes() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoCliente = conndb.prepareStatement("INSERT INTO clientes (nome, email, telefone,cpf) VALUES (?,?,?,?);");
            //Setar os parâmetros
            novoCliente.setString(1, "Pamella");
            novoCliente.setString(2, "pamellapereto@gmail.com");
            novoCliente.setString(3, "40028922");
            novoCliente.setString(4, "1234");
            int linhaAfetada = novoCliente.executeUpdate();
            conndb.close(); //Encerrar conexão após inserção
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir cliente: " + erro);
            return false;
        }
    }

    public boolean alterarCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement clienteAlterado = conndb.prepareStatement("UPDATE clientes SET nome = ?, email = ?, telefone = md5(?), cpf = ? WHERE id = ?;");
            clienteAlterado.setString(1, "Pamella");
            clienteAlterado.setString(2, "pamellapereto@gmail.com");
            clienteAlterado.setString(3, "123");
            clienteAlterado.setInt(4, 1);
            clienteAlterado.setInt(5, 1); //Alterar usuário c/ chave primária ID=1
            int linhaAfetada = clienteAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar cliente: " + erro);
            return false;
        }
    }

    public boolean deletarCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeCliente = conndb.prepareStatement
                    ("DELETE FROM clientes WHERE id = ?;");
            removeCliente.setInt(1, 1);
            int linhaAfetada = removeCliente.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar cliente: " + erro);
            return false;
        }
    }

    //Query SELECT
    public void pesquisarCliente() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaCliente = conndb.prepareStatement("SELECT nome, email,telefone,cpf FROM clientes WHERE id  = ?");
            buscaCliente.setInt(1, 21);
            ResultSet resultado = buscaCliente.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String telefone = resultado.getString("telefone");
                String cpf = resultado.getString("cpf");
                System.out.println("Nome: " + nome + " - Email: " + email+ " - Telefone: " + resultado.getString("telefone"));
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar cliente: " + erro);
        }
    }
}