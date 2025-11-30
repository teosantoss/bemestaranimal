package br.com.bemestaranimal;

import br.com.bemestaranimal.model.Animal;
import br.com.bemestaranimal.model.Tutor;
import br.com.bemestaranimal.model.Atendimento;
import br.com.bemestaranimal.model.Adocao;
import br.com.bemestaranimal.repository.*;
import br.com.bemestaranimal.service.*;

import java.time.LocalDate;

public class BemestaranimalApplication {
    public static void main(String[] args) {
        System.out.println("=== SPRINT 3 - SISTEMA BEM-ESTAR ANIMAL (ONG) ===");

        // Repos
        AnimalRepository animalRepo = new AnimalRepository();
        TutorRepository tutorRepo = new TutorRepository();
        AtendimentoRepository atendimentoRepo = new AtendimentoRepository();
        AdocaoRepository adocaoRepo = new AdocaoRepository();

        // Services
        AnimalService animalService = new AnimalService(animalRepo);
        TutorService tutorService = new TutorService(tutorRepo);
        AtendimentoService atendimentoService = new AtendimentoService(atendimentoRepo, animalRepo);
        AdocaoService adocaoService = new AdocaoService(adocaoRepo, animalRepo, tutorRepo);

        // 1) Cadastrar animais
        Animal a1 = new Animal(1, "Rex", "Cachorro", "SRD", 3, "Disponível");
        Animal a2 = new Animal(2, "Mimi", "Gato", "Siames", 2, "Disponível");
        Animal a3 = new Animal(3, "Bolt", "Cachorro", "Pastor", 5, "Abrigado"); // exemplo
        animalService.cadastrarAnimal(a1);
        animalService.cadastrarAnimal(a2);
        animalService.cadastrarAnimal(a3);

        // 2) Cadastrar tutores
        Tutor t1 = new Tutor(1, "Teófilo Antônio", "000.000.000-00", "99999-1111");
        Tutor t2 = new Tutor(2, "João Vitor Souza", "111.111.111-11", "99999-2222");
        tutorService.cadastrarTutor(t1);
        tutorService.cadastrarTutor(t2);

        // 3) Registrar atendimento para o animal 1
        Atendimento at1 = new Atendimento(1, 1, LocalDate.now(), "Vacinação e revisão", "Dr. Pedro");
        atendimentoService.registrarAtendimento(at1);

        // 4) Tutor 2 solicita adoção do animal 1
        adocaoService.solicitarAdocao(1, 1, 2); // adocao id=1, animalId=1, tutorId=2

        // 5) Aprovar adoção 1
        adocaoService.aprovarAdocao(1);

        // 6) Relatórios simples
        System.out.println("\n--- Relatório: Animais por status ---");
        for (Animal a : animalService.listarAnimais()) {
            System.out.println(a.getId() + " - " + a.getNome() + " - " + a.getStatus());
        }

        System.out.println("\n--- Histórico de atendimentos para animal 1 ---");
        for (Atendimento at : atendimentoService.historicoPorAnimal(1)) {
            System.out.println(at);
        }

        System.out.println("\n=== FIM DA SPRINT 3 ===");
    }
}
