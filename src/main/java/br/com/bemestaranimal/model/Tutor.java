package br.com.bemestaranimal.model;


public class Tutor {

    private int id;
    private String nome;
    private String cpf;
    private String telefone;

    public Tutor(int id, String nome, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    // getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getTelefone() { return telefone; }
}
