package abilities;

public class EfeitoStatus {
    private String nome;
    private String descricao;
    private int duracao; 
    private int danoPorTurno;
    private double multiplicadorDano;
    private double multiplicadorDefesa;

    public EfeitoStatus(String nome, String descricao, int duracao, int danoPorTurno, double multiplicadorDano, double multiplicadorDefesa) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.danoPorTurno = danoPorTurno;
        this.multiplicadorDano = multiplicadorDano;
        this.multiplicadorDefesa = multiplicadorDefesa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getDanoPorTurno() {
        return danoPorTurno;
    }

    public void setDanoPorTurno(int danoPorTurno) {
        this.danoPorTurno = danoPorTurno;
    }

    public double getMultiplicadorDano() {
        return multiplicadorDano;
    }

    public void setMultiplicadorDano(double multiplicadorDano) {
        this.multiplicadorDano = multiplicadorDano;
    }

    public double getMultiplicadorDefesa() {
        return multiplicadorDefesa;
    }

    public void setMultiplicadorDefesa(double multiplicadorDefesa) {
        this.multiplicadorDefesa = multiplicadorDefesa;
    }
    
    public void diminuirDuracao() {
        if (this.duracao > 0) {
            this.duracao--;
        }
    }

}
