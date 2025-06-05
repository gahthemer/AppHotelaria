package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDAO {
        private Conexao conexao = new Conexao();

        public boolean inserirQuartos() {

            try{
                Connection conndb = conexao.conectar();
                PreparedStatement novoAdicional = conndb.prepareStatement("insert into adicionais(nome, preco) values(?,?)");


                novoAdicional.setString(1,"travesseiro");
                novoAdicional.setDouble(2,20);

                int lihaAfetada = novoAdicional.executeUpdate();
                return lihaAfetada > 0;
            }
            catch (Exception erro){
                System.out.println("Erro ao inserir adicional"+erro);
                return false;
            }
        }
    }
