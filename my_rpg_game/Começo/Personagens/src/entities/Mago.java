package entities;

import abilities.HabilidadeCura;
import abilities.HabilidadeDanoMagico;
import abilities.HabilidadedeBuff;
import abilities.HabilidadedeDebuff;
import abilities.EfeitoStatus; // Importe a classe EfeitoStatus

public class Mago extends Heroi {

    public Mago(String nome, int destreza, int forca, int constituicao, int inteligencia, int sabedoria, int carisma, int nivel, int experiencia) {
        super(nome, destreza, forca, constituicao, inteligencia, sabedoria, carisma, "Mago", nivel, experiencia);
        
        // Crie os objetos EfeitoStatus
        EfeitoStatus efeitoEscudo = new EfeitoStatus("Escudo", "Aumenta a CA", 2, 0, 1.0, 1.5);
        EfeitoStatus efeitoImobilizado = new EfeitoStatus("Imobilizado", "Impede o movimento do alvo", 1, 0, 0.5, 1.0);

        this.addHabilidade(new HabilidadeDanoMagico("Bola de fogo", "Causa dano de fogo em um único inimigo.", 2, "Fogo", "Magico", 15));
        this.addHabilidade(new HabilidadedeBuff("Escudo", "Aumenta a Classe de Armadura por 2 turnos.", 4, "Buff", efeitoEscudo));
        this.addHabilidade(new HabilidadeDanoMagico("Flecha de vento", "Causa dano de vento e tem a chance de empurrar o inimigo para longe.", 3, "Vento", "Magico", 15));
        this.addHabilidade(new HabilidadeCura("Cura", "Restaura vida", 3, "Cura", 20));
        this.addHabilidade(new HabilidadedeDebuff("Prisão de agua", "Imobiliza o inimigo por um turno.", 5, "Debuff", efeitoImobilizado));
    }
}