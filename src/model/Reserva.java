package model;
import java.util.Date;

public class Reserva {
    private int id, pedido_id, quarto_id, adicional_id;
    private Date inicio, fim;

    public Reserva(int pedido_id, int quarto_id, int adicional_id, Date inicio, Date fim) {
        this.pedido_id = pedido_id;
        this.quarto_id = quarto_id;
        this.adicional_id = adicional_id;
        this.inicio = inicio;
        this.fim = fim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }

    public int getQuarto_id() {
        return quarto_id;
    }

    public void setQuarto_id(int quarto_id) {
        this.quarto_id = quarto_id;
    }

    public int getAdicional_id() {
        return adicional_id;
    }

    public void setAdicional_id(int adicional_id) {
        this.adicional_id = adicional_id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }
}
