package br.com.bemestaranimal.repository;

import br.com.bemestaranimal.model.Adocao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdocaoRepository {
    private final List<Adocao> store = new ArrayList<>();

    public void save(Adocao a) { store.add(a); }

    public List<Adocao> findAll() { return new ArrayList<>(store); }

    public Optional<Adocao> findById(int id) {
        return store.stream().filter(x -> x.getId() == id).findFirst();
    }
}
