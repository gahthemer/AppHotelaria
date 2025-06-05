package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario() {

        try{
            Connection conndb = conexao.conectar();
            PreparedStatement novoUsuario = conndb.prepareStatement("insert into usuarios(nome, email, senha,cargo_id) values(?,?,md5(?),?)");

            novoUsuario.setString(1,"Rayssa");
            novoUsuario.setString(2,"Rayssa@gmail.com");
            novoUsuario.setString(3,"123");
            novoUsuario.setInt(4,1);

            int lihaAfetada = novoUsuario.executeUpdate();
            return lihaAfetada > 0;
        }
        catch (Exception erro){
            System.out.println("Erro ao inserir usuario"+erro);
            return false;
        }
    }
}
