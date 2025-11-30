package br.com.bemestaranimal.model;

import java.time.LocalDate;

public class Adocao {
    private int id;
    private int animalId;
    private int tutorId;
    private LocalDate dataSolicitacao;
    private String status; // "PENDENTE", "APROVADA", "RECUSADA"
    private LocalDate dataConclusao;

    public Adocao(int id, int animalId, int tutorId, LocalDate dataSolicitacao, String status) {
        this.id = id;
        this.animalId = animalId;
        this.tutorId = tutorId;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
    }

    public int getId() { return id; }
    public int getAnimalId() { return animalId; }
    public int getTutorId() { return tutorId; }
    public LocalDate getDataSolicitacao() { return dataSolicitacao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getDataConclusao() { return dataConclusao; }
    public void setDataConclusao(LocalDate dataConclusao) { this.dataConclusao = dataConclusao; }

    @Override
    public String toString() {
        return "Adocao{" +
                "id=" + id +
                ", animalId=" + animalId +
                ", tutorId=" + tutorId +
                ", dataSolicitacao=" + dataSolicitacao +
                ", status='" + status + '\'' +
                ", dataConclusao=" + dataConclusao +
                '}';
    }
}
