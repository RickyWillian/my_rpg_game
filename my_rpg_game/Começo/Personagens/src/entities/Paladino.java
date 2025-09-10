package entities;

import itens.ItemArma;
import itens.ItemArmadura;
import abilities.HabilidadeCura;
import abilities.HabilidadedeBuff;
import abilities.EfeitoStatus; // Importe a classe EfeitoStatus

public class Paladino extends Heroi {

    public Paladino(String nome, int destreza, int forca, int constituicao, int inteligencia, int sabedoria, int carisma, int nivel, int experiencia) {
        super(nome, destreza, forca, constituicao, inteligencia, sabedoria, carisma, "Paladino", nivel, experiencia);
        
        this.equiparArma(new ItemArma("Espada Longa", "Uma espada longa e afiada, ideal para combates corpo a corpo.", 10, "Cortante"));
        this.equiparArmadura(new ItemArmadura("Armadura de Placas", "Uma armadura pesada feita de placas de metal, oferecendo alta proteção.", 15, "Pesada"));
        
        // Corrigido: Instanciando EfeitoStatus para a Aura Sagrada
        EfeitoStatus efeitoAuraSagrada = new EfeitoStatus("Aura Sagrada", "Aumenta a resistência a dano e a cura de todos os aliados.", 3, 0, 1.0, 1.2);
        this.addHabilidade(new HabilidadedeBuff("Aura Sagrada", "Aumenta a resistência a dano e a cura por turno de todos os aliados em uma área ao redor do Paladino. A duração é de 3 turnos.", 2, "Buff", efeitoAuraSagrada));
        
        this.addHabilidade(new HabilidadeCura("Cura Divina", "O Paladino pode usar uma ação para curar a si mesmo ou a um aliado, restaurando uma quantidade significativa de vida.", 2, "Cura", 20));
    }
}