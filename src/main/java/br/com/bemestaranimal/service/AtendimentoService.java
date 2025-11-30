package br.com.bemestaranimal.service;

import br.com.bemestaranimal.model.Atendimento;
import br.com.bemestaranimal.repository.AtendimentoRepository;
import br.com.bemestaranimal.repository.AnimalRepository;

import java.util.List;

public class AtendimentoService {
    private final AtendimentoRepository atendimentoRepo;
    private final AnimalRepository animalRepo;

    public AtendimentoService(AtendimentoRepository atendimentoRepo, AnimalRepository animalRepo) {
        this.atendimentoRepo = atendimentoRepo;
        this.animalRepo = animalRepo;
    }

    public void registrarAtendimento(Atendimento at) {
        // valida se animal existe
        if (animalRepo.findById(at.getAnimalId()).isEmpty()) {
            System.out.println("Erro: animal não encontrado para atendimento.");
            return;
        }
        atendimentoRepo.save(at);
        System.out.println("Atendimento registrado: " + at);
    }

    public List<Atendimento> historicoPorAnimal(int animalId) {
        return atendimentoRepo.findByAnimalId(animalId);
    }
}
