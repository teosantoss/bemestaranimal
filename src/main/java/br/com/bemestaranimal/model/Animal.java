package br.com.bemestaranimal.model;

public class Animal {

    private int id;
    private String nome;
    private String especie;
    private String raca;
    private int idadeAproximada;
    private String status; // "Abrigado", "Disponível", "Adotado"

    public Animal(int id, String nome, String especie, String raca, int idadeAproximada, String status) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idadeAproximada = idadeAproximada;
        this.status = status;
    }

    // GETTERS
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEspecie() { return especie; }
    public String getRaca() { return raca; }
    public int getIdadeAproximada() { return idadeAproximada; }
    public String getStatus() { return status; }

    // SETTER DE STATUS
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", raca='" + raca + '\'' +
                ", idadeAproximada=" + idadeAproximada +
                ", status='" + status + '\'' +
                '}';
    }
}
