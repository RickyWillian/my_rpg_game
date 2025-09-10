package abilities;

public class HabilidadeCura extends Habilidades {

    private int curaBase;
    

    public HabilidadeCura(String nome, String descricao, int custoPA, String tipo, int curaBase) {
        super(nome, descricao, custoPA, tipo);
        this.curaBase = curaBase;
    }
    public int getCuraBase() {
        return curaBase;
    }
   
    public void setCuraBase(int curaBase) {
        this.curaBase = curaBase;
    }
    @Override
    public void usarHabilidade(entities.Personagem user, entities.Personagem target) {
        System.out.println(user.getNome() + " usando habilidade: " + this.getNome() + " em " + target.getNome());
        target.heal(this.curaBase);
        System.out.println(target.getNome() + " foi curado em " + this.curaBase + " pontos. Vida atual: " + target.getVidaAtual());
    }

}