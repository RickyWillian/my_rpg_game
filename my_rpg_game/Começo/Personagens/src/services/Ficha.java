package services;

import entities.Heroi;
import entities.Personagem;


public class Ficha {

    private Personagem personagem;

    public Ficha(Personagem personagem) {
        this.personagem = personagem;
    }

    public void exibirFichaCompleta() {
        System.out.println("--- FICHA COMPLETA ---");
        System.out.println("Nome: " + personagem.getNome());
        System.out.println("Vida: " + personagem.getVidaAtual() + "/" + personagem.getVidaMax());
        System.out.println("Classe de Armadura: " + personagem.getClassearmor());

        System.out.println("\n--- ATRIBUTOS ---");
        System.out.println("Força: " + personagem.getForca());
        System.out.println("Destreza: " + personagem.getDestreza());
        System.out.println("Constituição: " + personagem.getConstituicao());
        System.out.println("Inteligência: " + personagem.getInteligencia());
        System.out.println("Sabedoria: " + personagem.getSabedoria());
        System.out.println("Carisma: " + personagem.getCarisma());

        if (personagem instanceof Heroi) {
            Heroi heroi = (Heroi) personagem;
            System.out.println("\n--- INFORMAÇÕES DO HERÓI ---");
            System.out.println("Classe: " + heroi.getClasse());
            System.out.println("Nível: " + heroi.getNivel());
            System.out.println("Experiência: " + heroi.getExperiencia());
            System.out.println("Pontos de Ação (PA): " + heroi.getPA());
        }
        System.out.println("---------------------------");
    }

    public void exibirStatusBatalha() {
        System.out.println("--- STATUS DE BATALHA ---");
        System.out.println("Nome: " + personagem.getNome());
        System.out.println("HP: " + personagem.getVidaAtual() + "/" + personagem.getVidaMax());
        
        if (personagem instanceof Heroi) {
            Heroi heroi = (Heroi) personagem;
            System.out.println("PA: " + heroi.getPA());
        }
        System.out.println("---------------------------\n");
    }
}