package entities;
import java.util.ArrayList;
import java.util.List;
import abilities.EfeitoStatus;
import abilities.Habilidades;
import itens.ItemArma;
import itens.ItemArmadura;

public class Personagem {
    private String nome;
    private int destreza;
    private int forca;
    private int constituicao;
    private int inteligencia;
    private int sabedoria;
    private int carisma;
    protected int vidaMax;
    protected int vidaAtual;
    protected int classearmor;
    private List<EfeitoStatus> efeitosAtivos = new ArrayList<>();
    private List<Habilidades> habilidades = new ArrayList<>();
    private ItemArma armaEquipada;
    private ItemArmadura armaduraEquipada;

    public Personagem(String nome, int destreza, int forca, int constituicao, int inteligencia, int sabedoria, int carisma, int vidaMax, int vidaAtual, int classearmor) {
        this.nome = nome;
        this.destreza = destreza;
        this.forca = forca;
        this.constituicao = constituicao;
        this.inteligencia = inteligencia;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.vidaMax = vidaMax;
        this.vidaAtual = vidaAtual;
        this.classearmor = classearmor;
    }

    public String getNome() { return nome; }
    public int getDestreza() { return destreza; }
    public int getForca() { return forca; }
    public int getConstituicao() { return constituicao; }
    public int getInteligencia() { return inteligencia; }
    public int getSabedoria() { return sabedoria; }
    public int getCarisma() { return carisma; }
    public int getVidaMax() { return vidaMax; }
    public int getVidaAtual() { return vidaAtual; }
    public int getClassearmor() { return classearmor; }
    public boolean isAlive() { return this.vidaAtual > 0; }
    public List<EfeitoStatus> getEfeitosAtivos() { return efeitosAtivos; }
    public List<Habilidades> getHabilidades() { return habilidades; }
    public ItemArma getArmaEquipada() { return armaEquipada; }
    public ItemArmadura getArmaduraEquipada() { return armaduraEquipada; }

    public void setNome(String nome) { this.nome = nome; }
    public void setDestreza(int destreza) { this.destreza = destreza; }
    public void setForca(int forca) { this.forca = forca; }
    public void setConstituicao(int constituicao) { this.constituicao = constituicao; }
    public void setInteligencia(int inteligencia) { this.inteligencia = inteligencia; }
    public void setSabedoria(int sabedoria) { this.sabedoria = sabedoria; }
    public void setCarisma(int carisma) { this.carisma = carisma; }
    public void setVidaMax(int hp) { this.vidaMax = hp; this.vidaAtual = hp; }
    public void setVidaAtual(int vidaAtual) { this.vidaAtual = vidaAtual; }
    public void calcClasseArmor(int ca) { this.classearmor = ca; }

    public void takeDamage(int damage) {
        int danoFinal = Math.max(0, damage - this.classearmor);
        this.vidaAtual -= danoFinal;
        if (this.vidaAtual < 0) this.vidaAtual = 0;
        System.out.println("  >> " + this.nome + " recebeu " + danoFinal + " de dano!");
    }

    public void heal(int healAmount) {
        this.vidaAtual += healAmount;
        if (this.vidaAtual > this.vidaMax) this.vidaAtual = this.vidaMax;
    }

    public void equiparArma(ItemArma arma) {
        this.armaEquipada = arma;
        System.out.println("  [Equipado] Arma: " + arma.getNome());
    }

    public void equiparArmadura(ItemArmadura armadura) {
        this.armaduraEquipada = armadura;
        System.out.println("  [Equipado] Armadura: " + armadura.getNome());
    }

    public void addHabilidade(Habilidades habilidade) {
        this.habilidades.add(habilidade);
        System.out.println("  [+] Habilidade aprendida: " + habilidade.getNome());
    }

    public void addEfeito(EfeitoStatus efeito) {
        this.efeitosAtivos.add(efeito);
    }
}