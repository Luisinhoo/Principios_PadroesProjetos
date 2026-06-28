public abstract class ItemDecorator extends Item {
    protected Item itemDecorado;

    public ItemDecorator(Item itemDecorado) {
        //Envia o nome e preço atuais para o construtor do Item base
        super(itemDecorado.getNome(), itemDecorado.getPreco());
        this.itemDecorado = itemDecorado;
    }

    @Override
    public abstract String getNome();

    @Override
    public abstract double getPreco();
}