package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    private String driver = "com.mysql.cj.jdbc.Driver";
    //jdbc:mysql://localhost:3306/dbHotel
    private String url = "jdbc:mysql://127.0.0.1:3306/dbHotel";
    private String usuario = "dbaHotel";
    private String senha = "dbaHotel123";

    public Connection conectar() {
        /*Objeto da conexao inicializa nulo pois não
        se sabe se o banco vai responder*/
        Connection condb = null;

        try {
            /*Especifica a rota do driver a ser carregado (JDBC para SGBD MySQL)*/
            Class.forName(driver);

            /*Inicializar o driver já carregado por meio do metodo getConnection(IP, porta, nome do banco, usuario, senha)*/
            condb = DriverManager.getConnection(url, usuario, senha);
            return condb;

        } catch (SQLException erro) {
            System.out.print("Erro ao conectar ao Banco de Dados " + erro);
            return null;
        }
    }
}
