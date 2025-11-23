package br.com.bemestaranimal.model;

public class Animal {

    private int id;
    private String nome;
    private String especie;
    private String status;

    public Animal(int id, String nome, String especie, String status) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
