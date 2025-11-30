package br.com.bemestaranimal.repository;

import br.com.bemestaranimal.model.Tutor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TutorRepository {
    private final List<Tutor> store = new ArrayList<>();

    public void save(Tutor tutor) { store.add(tutor); }

    public List<Tutor> findAll() { return new ArrayList<>(store); }

    public Optional<Tutor> findById(int id) {
        return store.stream().filter(t -> t.getId() == id).findFirst();
    }
}
