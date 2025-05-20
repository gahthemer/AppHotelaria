package model;
public class Usuario extends Pessoa {
private int id, role_id;
private String senha;
    public Usuario(String nome, String email, String senha, int role_id) {
        super(nome, email);
        this.senha = senha;
        this.role_id = role_id;
    }
    public int getId() {
        return id;
    }
    public int getRole_id() {
        return role_id;
    }
    public String getSenha() {
        return senha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
