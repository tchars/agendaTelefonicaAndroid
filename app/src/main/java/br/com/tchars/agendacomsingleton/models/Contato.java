package br.com.tchars.agendacomsingleton.models;

public class Contato {

    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private int tipoContato;

    private int idUsuarioPai;

    public Contato() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(int tipoContato) {
        this.tipoContato = tipoContato;
    }

    public int getIdUsuarioPai() {
        return idUsuarioPai;
    }

    public void setIdUsuarioPai(int idUsuarioPai) {
        this.idUsuarioPai = idUsuarioPai;
    }
}
