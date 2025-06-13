package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class reservaDAO {

        private Conexao conexao = new Conexao();

        public boolean inserirClientes() {

            try{
                Connection conndb = conexao.conectar();
                PreparedStatement novoReserva = conndb.prepareStatement("insert into reserva (inicio, fim) values(?,?)");

                //novoReserva.setDate(1,);
                //novoReserva.setDate(2,);

                int lihaAfetada = novoReserva.executeUpdate();
                return lihaAfetada > 0;
            }
            catch (Exception erro){
                System.out.println("Erro ao inserir cliente"+erro);
                return false;
            }
        }
    }
