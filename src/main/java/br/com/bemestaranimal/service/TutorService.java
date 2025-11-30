package br.com.bemestaranimal.service;

import br.com.bemestaranimal.model.Tutor;
import br.com.bemestaranimal.repository.TutorRepository;

import java.util.List;
import java.util.Optional;

public class TutorService {
    private final TutorRepository repo;

    public TutorService(TutorRepository repo) { this.repo = repo; }

    public void cadastrarTutor(Tutor tutor) {
        repo.save(tutor);
        System.out.println("Tutor cadastrado: " + tutor);
    }

    public Optional<Tutor> buscarPorId(int id) { return repo.findById(id); }

    public List<Tutor> listarTutors() { return repo.findAll(); }
}
