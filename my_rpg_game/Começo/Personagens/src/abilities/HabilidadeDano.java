package abilities;
import entities.Personagem;
import java.util.Random;

public class HabilidadeDano extends Habilidades {

    private int danoBase;
    private double mutipicadorCritico;
    private int chanceCritico;
    private Random random = new Random();

    public HabilidadeDano(String nome, String descricao, int custoPA, String tipo, int danoBase, double mutipicadorCritico, int chanceCritico) {
        super(nome, descricao, custoPA, tipo);
        this.danoBase = danoBase;
        this.mutipicadorCritico = mutipicadorCritico;
        this.chanceCritico = chanceCritico;
    }

    @Override
    public void usarHabilidade(Personagem user, Personagem target) {
        System.out.println(user.getNome() + " usando habilidade: " + this.getNome() + " em " + target.getNome());

        int danoTotal = this.danoBase;
        if (user.getForca() > user.getInteligencia()){
            danoTotal += user.getForca();
        } else {
            danoTotal += user.getInteligencia();
        }

        boolean isCritico = false;
        if (random.nextInt(100) < this.chanceCritico) {
            danoTotal *= this.mutipicadorCritico;
            isCritico = true;
            System.out.println("ACERTO CRÍTICO!");
        }

        target.takeDamage(danoTotal);

        if (isCritico) {
            System.out.println(user.getNome() + " causou " + danoTotal + " de dano CRÍTICO em " + target.getNome() + "!");
        } else {
            System.out.println(user.getNome() + " causou " + danoTotal + " de dano em " + target.getNome() + "!");
        }
        System.out.println(target.getNome() + " agora tem " + target.getVidaAtual() + " de vida.");
    }
}