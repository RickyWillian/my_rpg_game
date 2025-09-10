package abilities;

import entities.Personagem;

public class Habilidades {

    private String nome;
    private String descricao;
    private int custoPA;
    private String tipo;

    public Habilidades(String nome, String descricao, int custoPA, String tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.custoPA = custoPA;
        this.tipo = tipo;
    }
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public int getCustoPA() {
        return custoPA;
    }
    public String getTipo() {
        return tipo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setCustoPA(int custoPA) {
        this.custoPA = custoPA;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void usarHabilidade(Personagem user, Personagem target) {
        System.out.println("Usando habilidade: " + this.nome);
    }

}
