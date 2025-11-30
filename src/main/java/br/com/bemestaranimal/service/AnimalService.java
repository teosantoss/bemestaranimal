package br.com.bemestaranimal.service;

import br.com.bemestaranimal.model.Animal;
import br.com.bemestaranimal.repository.AnimalRepository;

import java.util.List;
import java.util.Optional;

public class AnimalService {
    private final AnimalRepository repo;

    public AnimalService(AnimalRepository repo) { this.repo = repo; }

    public void cadastrarAnimal(Animal animal) {
        repo.save(animal);
        System.out.println("Animal cadastrado: " + animal);
    }

    public List<Animal> listarAnimais() {
        return repo.findAll();
    }

    public Optional<Animal> buscarPorId(int id) { return repo.findById(id); }

    public void atualizarStatus(int animalId, String status) {
        repo.findById(animalId).ifPresent(a -> {
            a.setStatus(status);
            repo.update(a);
            System.out.println("Status atualizado do animal " + animalId + " para " + status);
        });
    }
}
