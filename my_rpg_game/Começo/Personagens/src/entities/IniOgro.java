package entities;
import itens.ItemArma;
import itens.ItemArmadura;
import abilities.HabilidadeDano;

public class IniOgro extends Personagem {
    public IniOgro(String nome, int destreza, int forca, int constituicao, int inteligencia, int sabedoria, int carisma) {
        super(nome, destreza, forca, constituicao, inteligencia, sabedoria, carisma, 15, 15, 12);
        this.equiparArma(new ItemArma("Clava Pesada", "Uma clava grande e pesada feita de madeira reforçada com ferro.", 12, "Contundente"));
        this.equiparArmadura(new ItemArmadura("Peitoral de Ferro", "Uma armadura pesada feita de placas de ferro.", 8, "Pesada"));
        this.addHabilidade(new HabilidadeDano("Golpe Brutal","Um ataque poderoso que causa dano extra. O dano base é aumentado em 30% e o dano crítico é aumentado em 50%.",2,"Contundente", 15, 1.5, 100));
    }
}