package itens;

public class ItemConsumivel extends Item{

    private String efeito;
    private int duracaoEfeito;
    
    public ItemConsumivel(String nome, String descricao, String efeito, int duracaoEfeito) {
        super(nome, descricao);
        this.efeito = efeito;
        this.duracaoEfeito = duracaoEfeito;
    }
    public String getEfeito() {
        return efeito;
    }
    public int getDuracaoEfeito() {
        return duracaoEfeito;
    }
    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }
    public void setDuracaoEfeito(int duracaoEfeito) {
        this.duracaoEfeito = duracaoEfeito;
    }
    @Override
    public void useItem() {
        super.useItem();
        System.out.println("Aplicando efeito: " + this.efeito + " por " + this.duracaoEfeito + " turnos.");
    }

}
