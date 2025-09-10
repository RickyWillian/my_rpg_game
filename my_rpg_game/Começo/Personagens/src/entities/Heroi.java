package entities;
import abilities.Habilidades;


public class Heroi extends Personagem {

    private String classe;
    private int nivel;
    private int experiencia;
    private int PA;

    public Heroi(String nome, int destreza, int forca, int constituicao, int inteligencia, int sabedoria, int carisma, String classe, int nivel, int experiencia) {
        super(nome, destreza, forca, constituicao, inteligencia, sabedoria, carisma, 0, 0, 0);
        this.classe = classe;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.PA = 3;
        this.calcVidaMax(nivel);
        this.calcClasseArmor(10 + (this.getDestreza() / 2));
    }

    public String getClasse() { return classe; }
    public int getNivel() { return nivel; }
    public int getExperiencia() { return experiencia; }
    public int getPA() { return PA; }

    public void setClasse(String classe) { this.classe = classe; }
    public void setNivel(int nivel) { this.nivel = nivel; }
    public void setExperiencia(int experiencia) { this.experiencia = experiencia; }
    public void setPA(int PA) { this.PA = PA; }

    public void addExperiencia(int experiencia) { this.experiencia += experiencia; }

    public void calcVidaMax (int nivel) {
        this.vidaMax = ((5 * nivel) + (getConstituicao() * nivel));
        this.vidaAtual = this.vidaMax;
    }

    public void attack(Personagem target) {
        // Lógica de ataque
    }

    public void usarHabilidade(Habilidades habilidade, Personagem target) {
        if (this.PA >= habilidade.getCustoPA()) {
            habilidade.usarHabilidade(this, target);
            this.PA -= habilidade.getCustoPA();
        } else {
            System.out.println("PA insuficiente para usar a habilidade " + habilidade.getNome());
        }
    }
}