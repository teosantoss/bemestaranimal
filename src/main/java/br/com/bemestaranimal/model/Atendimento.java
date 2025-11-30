package br.com.bemestaranimal.model;

import java.time.LocalDate;

public class Atendimento {
    private int id;
    private int animalId;
    private LocalDate data;
    private String descricao;
    private String veterinario;

    public Atendimento(int id, int animalId, LocalDate data, String descricao, String veterinario) {
        this.id = id;
        this.animalId = animalId;
        this.data = data;
        this.descricao = descricao;
        this.veterinario = veterinario;
    }

    public int getId() { return id; }
    public int getAnimalId() { return animalId; }
    public LocalDate getData() { return data; }
    public String getDescricao() { return descricao; }
    public String getVeterinario() { return veterinario; }

    @Override
    public String toString() {
        return "Atendimento{" +
                "id=" + id +
                ", animalId=" + animalId +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                ", veterinario='" + veterinario + '\'' +
                '}';
    }
}
