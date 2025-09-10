package entities;
import itens.ItemArma;
import itens.ItemArmadura;
import abilities.HabilidadeDano;
import abilities.HabilidadedeBuff;
import abilities.EfeitoStatus; 

public class Guerreiro extends Heroi {
    public Guerreiro(String nome, int destreza, int forca, int constituicao, int inteligencia, int sabedoria, int carisma, int nivel, int experiencia) {
        super(nome, destreza, forca, constituicao, inteligencia, sabedoria, carisma, "Guerreiro", nivel, experiencia);
        this.equiparArma(new ItemArma("Espada Longa", "Uma espada longa e afiada, ideal para combates corpo a corpo.", 10, "Cortante"));
        this.equiparArmadura(new ItemArmadura("Armadura de Placas", "Uma armadura pesada feita de placas de metal, oferecendo alta proteção.", 15, "Pesada"));
        this.addHabilidade(new HabilidadeDano("Ataque adicional", "O Guerreiro pode realizar um ataque adicional como parte de sua ação de ataque.", 1, "Passiva", 10, 1.5, 10));
        EfeitoStatus efeitoDefensivo = new EfeitoStatus("Postura Defensiva", "Aumenta a CA em 2", 2, 0, 1.0, 1.2);
        this.addHabilidade(new HabilidadedeBuff("Postura Defensiva", "O Guerreiro adota uma postura defensiva, aumentando sua Classe de Armadura (CA) em 2 até o início do seu próximo turno.", 1, "Buff", efeitoDefensivo));
    }
}