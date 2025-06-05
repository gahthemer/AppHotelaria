package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientesDAO {
        private Conexao conexao = new Conexao();

        public boolean inserirClientes() {

            try{
                Connection conndb = conexao.conectar();
                PreparedStatement novoClientes = conndb.prepareStatement("insert into clientes(nome, email, telefone,cpf) values(?,?,?,?)");

                novoClientes.setString(1,"Rayssa");
                novoClientes.setString(2,"Rayssa@gmail.com");
                novoClientes.setString(3,"40028922");
                novoClientes.setString(4,"400 7043 93");

                int lihaAfetada = novoClientes.executeUpdate();
                return lihaAfetada > 0;
            }
            catch (Exception erro){
                System.out.println("Erro ao inserir cliente"+erro);
                return false;
            }
        }
    }
