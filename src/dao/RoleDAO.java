package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoleDAO {
    //Objeto para instanciar classe Conexao para requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirRole() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement novoRole = conndb.prepareStatement("INSERT INTO cargos (nome) VALUES (?);");
            //Setar os parâmetros
            novoRole.setString(1, "Porteiro");
            int linhaAfetada = novoRole.executeUpdate();
            conndb.close(); //Encerrar conexão após inserção
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir cargo: " + erro);
            return false;
        }
    }

    public boolean alterarRole() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement clienteAlterado = conndb.prepareStatement("UPDATE cargos SET nome = ? WHERE id = ?;");
            clienteAlterado.setString(1, "camareira");
            clienteAlterado.setInt(2, 1); //Alterar usuário c/ chave primária ID=1
            int linhaAfetada = clienteAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao alterar cliente: " + erro);
            return false;
        }
    }

    public boolean deletarRole() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeRole = conndb.prepareStatement
                    ("DELETE FROM cargos WHERE id = ?;");
            removeRole.setInt(1, 1);
            removeRole.setInt(1, 2);
            int linhaAfetada = removeRole.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar cargo: " + erro);
            return false;
        }
    }

    //Query SELECT
    public void pesquisarRole() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaRole = conndb.prepareStatement("SELECT nome FROM cargos WHERE id  = ?");
            buscaRole.setInt(1, 21);
            ResultSet resultado = buscaRole.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");

                System.out.println("Nome: " + nome);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar cliente: " + erro);
        }
    }
}
