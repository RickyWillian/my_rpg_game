package abilities;

import entities.Personagem;
import entities.Heroi;

public class HabilidadedeDebuff extends Habilidades {

    private EfeitoStatus efeito;
    
    public HabilidadedeDebuff(String nome, String descricao, int custoPA, String tipo, EfeitoStatus efeito) {
        super(nome, descricao, custoPA, tipo);
        this.efeito = efeito;
    }

    public EfeitoStatus getEfeito() {
        return efeito;
    }

    @Override
    public void usarHabilidade(Personagem user, Personagem target) {
        
        if (user instanceof Heroi) {
            Heroi heroi = (Heroi) user;

            
            if (heroi.getPA() >= this.getCustoPA()) {
                heroi.setPA(heroi.getPA() - this.getCustoPA());

                // Adicione o efeito diretamente ao alvo
                target.addEfeito(this.efeito);

                
                System.out.println(heroi.getNome() + " aplica o debuff " + this.efeito.getNome() + " em " + target.getNome() + " por " + this.efeito.getDuracao() + " turnos.");

            } else {
                System.out.println("PA insuficiente para usar " + this.getNome() + "!");
            }
        } else {
            
            System.out.println(user.getNome() + " não pode usar essa habilidade!");
        }
    }
}