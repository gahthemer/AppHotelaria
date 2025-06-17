package dao;

import model.Pedido;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

    public class PedidosDAO {

        private Conexao conexao = new Conexao();

        public boolean inserirPedido() {
            try {
                Connection conndb = conexao.conectar();
                PreparedStatement novoPedido = conndb.prepareStatement("INSERT INTO pedidos (usuario_id, cliente_id,data, pagamento) VALUES (?, ?, ?,?);");
                novoPedido.setInt(1, 5);
                novoPedido.setInt(2, 21);
                novoPedido.setString(3, "2001-06-07");
                novoPedido.setString(4, "pix");

                int linhaAfetada = novoPedido.executeUpdate();
                conndb.close();
                return linhaAfetada > 0;

            } catch (Exception erro) {
                System.out.println("Erro ao inserir pedido: " + erro);
                return false;
            }
        }

        public boolean alterarPedido() {
            try {
                Connection conndb = conexao.conectar();
                PreparedStatement pedidoAlterado = conndb.prepareStatement("UPDATE pedidos SET usuario_id = ?, cliente_id = ?, data = ?, pagamento = ? WHERE id = ?;");
                pedidoAlterado.setInt(1, 5);
                pedidoAlterado.setInt(2, 21);
                pedidoAlterado.setString(3, "2025-06-01");
                pedidoAlterado.setString(4, "Pix");
                pedidoAlterado.setInt(5, 3);

                int linhaAfetada = pedidoAlterado.executeUpdate();
                conndb.close();
                return linhaAfetada > 0;

            } catch (Exception erro) {
                System.out.println("Erro ao alterar pedido: " + erro);
                return false;
            }
        }

        public boolean deletarPedido() {
            try {
                Connection conndb = conexao.conectar();
                PreparedStatement removePedido = conndb.prepareStatement(
                        "DELETE FROM pedidos WHERE id = ?;"
                );
                removePedido.setInt(1, 3);

                int linhaAfetada = removePedido.executeUpdate();
                conndb.close();
                return linhaAfetada > 0;

            } catch (Exception erro) {
                System.out.println("Erro ao deletar pedido: " + erro);
                return false;
            }
        }

        public void pesquisarPedido() {
            try {
                Connection conndb = conexao.conectar();
                PreparedStatement buscaPedido = conndb.prepareStatement("SELECT usuario_id, cliente_id, pagamento FROM pedidos WHERE id = ?");
                buscaPedido.setInt(1, 3);

                ResultSet resultado = buscaPedido.executeQuery();
                while (resultado.next()) {
                    String usuario_id = resultado.getString("usuario_id");
                    String cliente_id = resultado.getString("cliente_id");
                    String pagamento = resultado.getString("pagamento");
                    System.out.println("Usuario_id: " + usuario_id +
                            " - Cliente_id: " + cliente_id +
                            " - Pagamento: " + pagamento);
                }
                conndb.close();

            } catch (Exception erro) {
                System.out.println("Erro ao pesquisar pedido: " + erro);
            }
        }
    }
