package services;

import entities.Heroi;
import entities.Personagem;
import abilities.Habilidades;
import java.util.Scanner;

public class Batalha {

    private Heroi heroi;
    private Personagem inimigo;
    private Scanner scanner;
    private Ficha fichaHeroi;
    private Ficha fichaInimigo;

    public Batalha(Heroi heroi, Personagem inimigo) {
        this.heroi = heroi;
        this.inimigo = inimigo;
        this.scanner = new Scanner(System.in);
        this.fichaHeroi = new Ficha(heroi);
        this.fichaInimigo = new Ficha(inimigo);
    }

    public void iniciarBatalha() {
        System.out.println("\n====================================");
        System.out.println("A BATALHA COMEÇOU: " + heroi.getNome() + " VS " + inimigo.getNome());
        System.out.println("====================================");

        while (heroi.isAlive() && inimigo.isAlive()) {
            turnoDoHeroi();
            if (!inimigo.isAlive()) break;
            turnoDoInimigo();
        }

        if (heroi.isAlive()) {
            System.out.println("\nVITÓRIA! " + heroi.getNome() + " venceu a batalha!");
        } else {
            System.out.println("\nDERROTA! " + heroi.getNome() + " foi derrotado.");
        }
    }

    private void turnoDoHeroi() {
        heroi.setPA(3); // Reinicia os Pontos de Ação no início do turno
        System.out.println("\n--- TURNO DE " + heroi.getNome().toUpperCase() + " ---");
        fichaHeroi.exibirStatusBatalha();
        fichaInimigo.exibirStatusBatalha();

        System.out.println("Escolha sua ação:");
        System.out.println("1. Ataque Básico com Arma");
        System.out.println("2. Usar Habilidade");
        System.out.print("Opção: ");

        int escolha = scanner.nextInt();
        scanner.nextLine(); 

        switch (escolha) {
            case 1:
                ataqueBasico(heroi, inimigo);
                break;
            case 2:
                escolherHabilidade();
                break;
            default:
                System.out.println("Opção inválida. Você perdeu seu turno!");
                break;
        }
    }
    
    private void ataqueBasico(Personagem atacante, Personagem alvo) {
        System.out.println(atacante.getNome() + " ataca " + alvo.getNome() + " com " + atacante.getArmaEquipada().getNome() + "!");
        int danoArma = atacante.getArmaEquipada().getDano();
        int bonusAtributo = (atacante.getForca() > atacante.getInteligencia()) ? atacante.getForca() : atacante.getInteligencia();
        int danoTotal = danoArma + bonusAtributo;
        
        alvo.takeDamage(danoTotal);
    }

    private void escolherHabilidade() {
        System.out.println("Escolha uma habilidade para usar:");
        for (int i = 0; i < heroi.getHabilidades().size(); i++) {
            Habilidades hab = heroi.getHabilidades().get(i);
            System.out.println((i + 1) + ". " + hab.getNome() + " (Custo: " + hab.getCustoPA() + " PA)");
        }
        System.out.print("Opção: ");
        int escolhaHab = scanner.nextInt() - 1;
        scanner.nextLine();

        if (escolhaHab >= 0 && escolhaHab < heroi.getHabilidades().size()) {
            Habilidades habilidadeEscolhida = heroi.getHabilidades().get(escolhaHab);
            heroi.usarHabilidade(habilidadeEscolhida, inimigo);
        } else {
            System.out.println("Habilidade inválida! Você perdeu o turno.");
        }
    }

    private void turnoDoInimigo() {
        System.out.println("\n--- TURNO DE " + inimigo.getNome().toUpperCase() + " ---");
        // IA Simples: O inimigo sempre usa a primeira habilidade que tiver.
        if (!inimigo.getHabilidades().isEmpty()) {
            Habilidades habilidadeInimigo = inimigo.getHabilidades().get(0);
            habilidadeInimigo.usarHabilidade(inimigo, heroi);
        } else {
            ataqueBasico(inimigo, heroi);
        }
    }
}