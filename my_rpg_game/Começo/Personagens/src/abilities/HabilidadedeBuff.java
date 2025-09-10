package abilities;

import entities.Personagem;
import entities.Heroi;

public class HabilidadedeBuff extends Habilidades {

    private EfeitoStatus efeito;

    public HabilidadedeBuff(String nome, String descricao, int custoPA, String tipo, EfeitoStatus efeito) {
        super(nome, descricao, custoPA, tipo);
        this.efeito = efeito;
    }

    public EfeitoStatus getEfeito() {
        return efeito;
    }
    
   // Em HabilidadedeBuff.java

@Override
public void usarHabilidade(Personagem user, Personagem target) {
    // Verifique se o usuário da habilidade é um herói
    if (user instanceof Heroi) {
        Heroi heroi = (Heroi) user; // Faça o cast para Heroi
        
        // Agora você pode usar os métodos de Heroi
        if (heroi.getPA() >= this.getCustoPA()) {
            heroi.setPA(heroi.getPA() - this.getCustoPA());
            
            // Adicione o efeito diretamente ao alvo
            target.addEfeito(this.efeito);

            System.out.println(heroi.getNome() + " aplica o buff " + this.efeito.getNome() + " em " + target.getNome() + " por " + this.efeito.getDuracao() + " turnos.");
            
        } else {
            System.out.println("PA insuficiente para usar " + this.getNome() + "!");
        }
    } else {
        // Se o usuário não for um herói, ele não pode usar habilidades baseadas em PA
        System.out.println(user.getNome() + " não pode usar essa habilidade!");
    }
}
}