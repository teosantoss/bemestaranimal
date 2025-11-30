package br.com.bemestaranimal.repository;

import br.com.bemestaranimal.model.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnimalRepository {
    private final List<Animal> store = new ArrayList<>();

    public void save(Animal animal) { store.add(animal); }

    public List<Animal> findAll() { return new ArrayList<>(store); }

    public Optional<Animal> findById(int id) {
        return store.stream().filter(a -> a.getId() == id).findFirst();
    }

    public void update(Animal animal) {
        findById(animal.getId()).ifPresent(existing -> {
            existing.setStatus(animal.getStatus());
            // para sprint simples mantemos apenas atualização de status aqui
        });
    }
}
