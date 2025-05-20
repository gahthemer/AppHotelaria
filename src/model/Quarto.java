package model;

public class Quarto {
    private int id, qtd_cama_casal, qtd_cama_solteiro;
    private String nome, numero;
    private double preco;
    private Boolean disponivel;

    public Quarto(int qtd_cama_casal, int qtd_cama_solteiro, String nome, String numero, double preco, Boolean disponivel) {
        this.qtd_cama_casal = qtd_cama_casal;
        this.qtd_cama_solteiro = qtd_cama_solteiro;
        this.nome = nome;
        this.numero = numero;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtd_cama_casal() {
        return qtd_cama_casal;
    }

    public void setQtd_cama_casal(int qtd_cama_casal) {
        this.qtd_cama_casal = qtd_cama_casal;
    }

    public int getQtd_cama_solteiro() {
        return qtd_cama_solteiro;
    }

    public void setQtd_cama_solteiro(int qtd_cama_solteiro) {
        this.qtd_cama_solteiro = qtd_cama_solteiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}
