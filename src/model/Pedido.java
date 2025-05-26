package model;

import java.util.Date;

public class Pedido {
    private int id, usuario_id, cliente_id;
    private Date data;
    private String pagamento;
    public Pedido(int usuario_id, int cliente_id, Date data, String pagamento) {
        this.usuario_id = usuario_id;
        this.cliente_id = cliente_id;
        this.data = data;
        this.pagamento = pagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
}
