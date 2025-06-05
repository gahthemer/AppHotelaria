package util;

import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Conexao {
    private String driver;
    //jdbc:mysql://localhost:3306/dbHotel
    private String url;
    private String usuario;
    private String senha ;
    private Connection connection;

    public Conexao() {
        carregarConfiguracoes();
    }

    private void carregarConfiguracoes() {
        Properties props = new Properties();
        try (InputStream inputPropsConfig = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            props.load(inputPropsConfig);
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            usuario = props.getProperty("usuario");
            senha = props.getProperty("senha");
        }
        catch (IOException erro) {
            System.out.println("Erro ao carregar configuracoes" + erro.getMessage());
        }
    }

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
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
