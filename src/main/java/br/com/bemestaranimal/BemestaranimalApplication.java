package br.com.bemestaranimal;

import br.com.bemestaranimal.model.Animal;
import br.com.bemestaranimal.model.Tutor;

public class BemestaranimalApplication {

    public static void main(String[] args) {

        System.out.println("=== SPRINT 2 - SISTEMA BEM-ESTAR ANIMAL ===");

        Animal animal1 = new Animal(1, "Rex", "Cachorro", "Disponível");
        Tutor tutor1 = new Tutor(1, "João Vitor Souza", "99999-0000");

        System.out.println("Animal cadastrado:");
        System.out.println(animal1);

        System.out.println("Tutor cadastrado:");
        System.out.println(tutor1);
    }
}
// test commit