package entities;

import itens.ItemArma;
import itens.ItemArmadura;
import abilities.HabilidadeDano;
import abilities.HabilidadedeBuff;
import abilities.EfeitoStatus; // Importe a classe EfeitoStatus

public class Assassino extends Heroi {

    public Assassino(String nome, int destreza, int forca, int constituicao, int inteligencia, int sabedoria, int carisma, int nivel, int experiencia) {
        super(nome, destreza, forca, constituicao, inteligencia, sabedoria, carisma, "Assassino", nivel, experiencia);
        
        this.equiparArma(new ItemArma("Adaga", "Uma adaga afiada e leve.", 8, "Perfurante"));
        this.equiparArmadura(new ItemArmadura("Armadura de Couro", "Uma armadura leve feita de couro reforçado.", 5, "Leve"));
        
        this.addHabilidade(new HabilidadeDano("Ataque Furtivo", "Um ataque surpresa que causa dano extra quando o inimigo está desprevenido. O dano base é aumentado em 50% e o dano crítico dobra, resultando em um dano massivo.", 2, "Perfurante", 12, 1.5, 100));
        this.addHabilidade(new HabilidadeDano("Golpe Letal", "Um ataque rápido que causa dano moderado e tem uma chance maior de causar sangramento, que aplica dano por turno.", 1, "Perfurante", 10, 1.5, 30));
        
        // Corrigido: Instanciando EfeitoStatus para a Evasão
        EfeitoStatus efeitoEvasao = new EfeitoStatus("Evasão", "Aumenta a chance de esquiva", 2, 0, 1.0, 1.5);
        this.addHabilidade(new HabilidadedeBuff("Evasão", "Assassino pode se mover rapidamente, aumentando sua chance de esquivar-se de ataques por 2 turnos.", 1, "Buff", efeitoEvasao));
    }
}