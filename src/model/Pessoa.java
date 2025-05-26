package model;

public class Pessoa {
    /*Declaração de variáveis com
    modificador de acesso e tipagem*/
    private String nome, email;

    /*Construtor: inicializa a classe
    quando um objeto é criado*/
    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

