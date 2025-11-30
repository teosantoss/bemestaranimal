package br.com.bemestaranimal.service;

import br.com.bemestaranimal.model.Adocao;
import br.com.bemestaranimal.model.Animal;
import br.com.bemestaranimal.repository.AdocaoRepository;
import br.com.bemestaranimal.repository.AnimalRepository;
import br.com.bemestaranimal.repository.TutorRepository;

import java.time.LocalDate;
import java.util.Optional;

public class AdocaoService {
    private final AdocaoRepository repo;
    private final AnimalRepository animalRepo;
    private final TutorRepository tutorRepo;

    public AdocaoService(AdocaoRepository repo, AnimalRepository animalRepo, TutorRepository tutorRepo) {
        this.repo = repo;
        this.animalRepo = animalRepo;
        this.tutorRepo = tutorRepo;
    }

    public void solicitarAdocao(int idAdocao, int animalId, int tutorId) {
        Optional<Animal> animalOpt = animalRepo.findById(animalId);
        Optional<?> tutorOpt = tutorRepo.findById(tutorId);
        if (animalOpt.isEmpty()) {
            System.out.println("Erro: animal não encontrado.");
            return;
        }
        if (tutorOpt.isEmpty()) {
            System.out.println("Erro: tutor não encontrado.");
            return;
        }
        Animal animal = animalOpt.get();
        if ("Adotado".equalsIgnoreCase(animal.getStatus())) {
            System.out.println("Erro: animal já adotado.");
            return;
        }
        Adocao ad = new Adocao(idAdocao, animalId, tutorId, LocalDate.now(), "PENDENTE");
        repo.save(ad);
        System.out.println("Solicitação de adoção criada: " + ad);
    }

    public void aprovarAdocao(int adocaoId) {
        Optional<Adocao> opt = repo.findById(adocaoId);
        if (opt.isEmpty()) {
            System.out.println("Erro: adoção não encontrada.");
            return;
        }
        Adocao a = opt.get();
        if (!"PENDENTE".equalsIgnoreCase(a.getStatus())) {
            System.out.println("Adoção não está pendente.");
            return;
        }
        // verifica se animal já está adotado
        Optional<Animal> animalOpt = animalRepo.findById(a.getAnimalId());
        if (animalOpt.isEmpty()) {
            System.out.println("Erro: animal não encontrado.");
            return;
        }
        Animal animal = animalOpt.get();
        if ("Adotado".equalsIgnoreCase(animal.getStatus())) {
            System.out.println("Erro: animal já adotado.");
            a.setStatus("RECUSADA");
            a.setDataConclusao(LocalDate.now());
            return;
        }
        // aprova
        a.setStatus("APROVADA");
        a.setDataConclusao(LocalDate.now());
        animal.setStatus("Adotado");
        animalRepo.update(animal);
        System.out.println("Adoção aprovada: " + a);
        System.out.println("Status do animal atualizado para Adotado: " + animal);
    }
}
