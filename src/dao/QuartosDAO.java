package dao;

import model.Quarto;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuartosDAO {
        private Conexao conexao = new Conexao();

        public boolean inserirQuartos(Quarto quarto) {

            try{
                Connection conndb = conexao.conectar();
                PreparedStatement novoQuartos = conndb.prepareStatement("insert into quartos(nome, numero, qnt_cama_casal,qnt_cama_solteiro,preco,disponivel) values(?,?,?,?,?,?)");

                novoQuartos.setString(1,"Suite de luxo");
                novoQuartos.setString(2,"15");
                novoQuartos.setInt(3,20);
                novoQuartos.setInt(4,20);
                novoQuartos.setDouble(5,400);
                novoQuartos.setBoolean(6,true);

                int lihaAfetada = novoQuartos.executeUpdate();
                conndb.close();
                return lihaAfetada > 0;
            }
            catch (Exception erro){
                System.out.println("Erro ao inserir quarto"+erro);
                return false;
            }
        }

    public boolean alterarQuartos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement quartoAlterado  = conndb.prepareStatement("UPDATE quartos SET nome = ?, numero = ?,qnt_cama_casal = ?,qnt_cama_solteiro = ?,preco = ?,disponivel = ? WHERE id = ?;");
            quartoAlterado.setString(1, "Suite de luxo");
            quartoAlterado.setString(2, "15");
            quartoAlterado.setInt(3, 20);
            quartoAlterado.setInt(4, 20);
            quartoAlterado.setInt(5, 400);//Alterar usuário c/ chave primária ID=1
            quartoAlterado.setBoolean(6, true);
            quartoAlterado.setInt(7, 1);
            int linhaAfetada = quartoAlterado.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao alterar quarto: " + erro);
            return false;
        }
    }

    public boolean deletarQuartos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement removeQuarto = conndb.prepareStatement
                    ("DELETE FROM quartos WHERE id = ?;");
            removeQuarto.setInt(1, 1);
            int linhaAfetada = removeQuarto.executeUpdate();
            conndb.close();
            return linhaAfetada > 0;
        }
        catch (Exception erro) {
            System.out.println("Erro ao deletar quarto: " + erro);
            return false;
        }
    }

    //Query SELECT
    public void pesquisarQuartos() {
        try {
            Connection conndb = conexao.conectar();
            PreparedStatement buscaQuarto = conndb.prepareStatement("SELECT nome,numero,qnt_cama_casal,qnt_cama_solteiro,preco,disponivel FROM quartos WHERE id  = ?");
            buscaQuarto.setInt(1, 21);
            ResultSet resultado = buscaQuarto.executeQuery();

            while (resultado.next()) {
                String nome = resultado.getString("nome");
                String numero = resultado.getString("numero");
                Integer qnt = resultado.getInt("qnt_cama_casal");
                Integer qnt_cama = resultado.getInt("qnt_cama_solteiro");
                Double preco = resultado.getDouble("preco");
                Boolean disponivel = resultado.getBoolean("disponivel");
                System.out.println("Nome: " + nome + " - Email: " + numero+"Quartos: " + qnt+"Quartos: " + qnt_cama+"preco: " + preco+"Disponivel: " + disponivel);
            }
            conndb.close();
        }
        catch (Exception erro) {
            System.out.println("Erro ao pesquisar quarto: " + erro);
        }
    }
}

