package entities;
import itens.ItemArma;
import itens.ItemArmadura;
import abilities.HabilidadeDano;

public class IniGoblin extends Personagem {
    public IniGoblin(String nome, int destreza, int forca, int constituicao, int inteligencia, int sabedoria, int carisma) {
        super(nome, destreza, forca, constituicao, inteligencia, sabedoria, carisma, 15, 15, 12);
        this.equiparArma(new ItemArma("Adaga Envenenada", "Uma adaga pequena e afiada com uma lâmina envenenada.", 8, "Perfurante"));
        this.equiparArmadura(new ItemArmadura("Couro Batido", "Uma armadura leve feita de couro reforçado.", 4, "Leve"));
        this.addHabilidade(new HabilidadeDano("Ataque Furtivo", "Um ataque surpresa que causa dano extra se o inimigo estiver desprevenido.", 2, "Perfurante", 10, 1.5, 10));
    }
}