package br.com.tchars.agendacomsingleton.models;

public class Usuario {

    private int id;
    private String nomeDeUsuario;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String senha) {
        this.nomeDeUsuario = nome;
        this.senha = senha;
    }

    public Usuario(int id, String nome, String senha) {
        this.id = id;
        this.nomeDeUsuario = nome;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
