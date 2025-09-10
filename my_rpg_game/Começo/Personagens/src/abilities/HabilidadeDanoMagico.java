package abilities;
import entities.Personagem;

public class HabilidadeDanoMagico extends Habilidades {

    private String tipoDano;
    private int danoBase;

    public HabilidadeDanoMagico(String nome, String descricao, int custoPA, String tipo, String tipoDano, int danoBase) {
        super(nome, descricao, custoPA, tipo);
        this.tipoDano = tipoDano;
        this.danoBase = danoBase;
    }

    @Override
    public void usarHabilidade(Personagem user, Personagem target) {
        System.out.println(user.getNome() + " usando habilidade: " + this.getNome() + " em " + target.getNome());

        int danoTotal = this.danoBase + user.getInteligencia();
        target.takeDamage(danoTotal);

        System.out.println(user.getNome() + " causou " + danoTotal + " de dano mágico em " + target.getNome() + "!");
        System.out.println(target.getNome() + " agora tem " + target.getVidaAtual() + " de vida.");
    }
}