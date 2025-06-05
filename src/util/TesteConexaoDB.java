package util;

import dao.*;
import model.Usuario;

import java.sql.Connection;

public class TesteConexaoDB {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection condb = conexao.conectar();
        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");

            try {
                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
                adicionaisDAO.inserirQuartos();
                System.out.println("cliente Inserido com sucesso!");

                RoleDAO roleDAO = new RoleDAO();
                roleDAO.inserirRole();

                 QuartosDAO quartosDAO = new QuartosDAO();
                 quartosDAO.inserirQuartos();

                 ClientesDAO clientesDAO = new ClientesDAO();
                 clientesDAO.inserirClientes();

                 UsuariosDAO usuariosDAO = new UsuariosDAO();
                 usuariosDAO.inserirUsuario();

                condb.close();
                System.out.println("conexão encerrada!");

            } catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão: " + erro.getMessage());
            }
        } else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}
