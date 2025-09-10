package entities;

import itens.ItemArma;
import abilities.HabilidadeDano;
import abilities.HabilidadedeBuff;
import abilities.EfeitoStatus; // Importe a classe EfeitoStatus

public class Barbaro extends Heroi {

    public Barbaro(String nome, int destreza, int forca, int constituicao, int inteligencia, int sabedoria, int carisma, int nivel, int experiencia) {
        super(nome, destreza, forca, constituicao, inteligencia, sabedoria, carisma, "Barbaro", nivel, experiencia);
        
        this.equiparArma(new ItemArma("Machado de Batalha", "Um machado grande e pesado, ideal para causar grandes danos.", 12, "Cortante"));
        
        this.addHabilidade(new HabilidadeDano("Investida", "O Bárbaro ataca e causa dano e imobiliza o inimigo por um turno.", 2, "Impacto", 18, 1.5, 100));
        
        // Corrigido: Instanciando EfeitoStatus para o Berserk
        EfeitoStatus efeitoBerserk = new EfeitoStatus("Berserk", "Aumenta vida e dano, e torna o Bárbaro imparável.", 3, 0, 1.25, 1.0);
        this.addHabilidade(new HabilidadedeBuff("Berserk", "O Bárbaro aumenta sua vida e dano em porcentagem. Ele se torna imparável por 3 turnos (imune a atordoamento e imobilização)", 2, "Buff", efeitoBerserk));
    }
}