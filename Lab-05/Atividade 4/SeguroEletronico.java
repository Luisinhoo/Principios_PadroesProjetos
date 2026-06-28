public class SeguroEletronico extends ItemDecorator {
    public SeguroEletronico(Item itemDecorado) {
        super(itemDecorado);
    }

    @Override
    public String getNome() {
        return itemDecorado.getNome() + " (Com Seguro)";
    }

    @Override
    public double getPreco() {
        return itemDecorado.getPreco() + 50.00; //Adiciona R$ 50,00
    }
}