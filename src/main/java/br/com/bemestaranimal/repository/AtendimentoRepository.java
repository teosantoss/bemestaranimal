package br.com.bemestaranimal.repository;

import br.com.bemestaranimal.model.Atendimento;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoRepository {
    private final List<Atendimento> store = new ArrayList<>();

    public void save(Atendimento atendimento) { store.add(atendimento); }

    public List<Atendimento> findAll() { return new ArrayList<>(store); }

    public List<Atendimento> findByAnimalId(int animalId) {
        List<Atendimento> result = new ArrayList<>();
        for (Atendimento a : store) {
            if (a.getAnimalId() == animalId) result.add(a);
        }
        return result;
    }
}
