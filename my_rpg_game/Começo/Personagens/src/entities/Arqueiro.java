package entities;

import itens.ItemArma;
import itens.ItemArmadura;
import abilities.HabilidadeDano;

public class Arqueiro extends Heroi {

    public Arqueiro(String nome, int destreza, int forca, int constituicao, int inteligencia, int sabedoria, int carisma, int nivel, int experiencia) {
        super(nome, destreza, forca, constituicao, inteligencia, sabedoria, carisma, "Arqueiro", nivel, experiencia);
        
        this.equiparArma(new ItemArma("Arco Longo", "Um arco longo feito de madeira resistente.", 10, "Perfurante"));
        this.equiparArmadura(new ItemArmadura("Armadura de Couro", "Uma armadura leve feita de couro reforçado.", 5, "Leve"));
        
        this.addHabilidade(new HabilidadeDano("Flecha Carregada", "Aumente o dano do próximo ataque. Adicione um efeito de status de Impedir Movimento no alvo por 1 turno. O dano base é aumentado em 50% e o dano crítico dobra, resultando em um dano massivo.", 2, "Perfurante", 15, 1.5, 100));
        this.addHabilidade(new HabilidadeDano("Flecha Múltipla", "O Arqueiro pode disparar três flechas em um único turno, cada uma causando dano base reduzido (50% do dano normal).", 2, "Perfurante", 8, 1.5, 10));
        this.addHabilidade(new HabilidadeDano("Ataque basico", "Um ataque básico com o arco.", 1, "Perfurante", 10, 1.5, 10));
    }
}