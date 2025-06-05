package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartosDAO {
        private Conexao conexao = new Conexao();

        public boolean inserirQuartos() {

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
                return lihaAfetada > 0;
            }
            catch (Exception erro){
                System.out.println("Erro ao inserir quarto"+erro);
                return false;
            }
        }
    }
