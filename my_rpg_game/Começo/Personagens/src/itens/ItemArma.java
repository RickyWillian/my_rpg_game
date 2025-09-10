package itens;

public class ItemArma extends Item {

    private int dano;
    private String tipoDano;

    public ItemArma(String nome, String descricao, int dano, String tipoDano) {
        super(nome, descricao);
        this.dano = dano;
        this.tipoDano = tipoDano;
    }
    public int getDano() {
        return dano;
    }
    public String getTipoDano() {
        return tipoDano;
    }
    public void setDano(int dano) {
        this.dano = dano;
    }
    public void setTipoDano(String tipoDano) {
        this.tipoDano = tipoDano;
    }
    @Override
    public void useItem() {
        super.useItem();
        System.out.println("Causando " + this.dano + " de dano do tipo " + this.tipoDano);
    }
    

}
