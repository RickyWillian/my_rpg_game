package itens;

public class ItemArmadura extends Item {
    private int defesa;
    private String tipoArmadura;

    public ItemArmadura(String nome, String descricao, int defesa, String tipoArmadura) {
        super(nome, descricao);
        this.defesa = defesa;
        this.tipoArmadura = tipoArmadura;
    }
    public int getDefesa() {
        return defesa;
    }
    public String getTipoArmadura() {
        return tipoArmadura;
    }
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
    public void setTipoArmadura(String tipoArmadura) {
        this.tipoArmadura = tipoArmadura;
    }
    @Override
    public void useItem() {
        super.useItem();
        System.out.println("Aumentando defesa em " + this.defesa + " com armadura do tipo " + this.tipoArmadura);
    }

}
