package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RoleDAO {
        private Conexao conexao = new Conexao();

        public boolean inserirRole() {

            try{
                Connection conndb = conexao.conectar();
                PreparedStatement novoRole = conndb.prepareStatement("insert into cargos(nome) values(?)");

                novoRole.setString(1,"Gerente");

                int lihaAfetada = novoRole.executeUpdate();
                return lihaAfetada > 0;
            }
            catch (Exception erro){
                System.out.println("Erro ao inserir Cargo"+erro);
                return false;
            }
        }
    }
