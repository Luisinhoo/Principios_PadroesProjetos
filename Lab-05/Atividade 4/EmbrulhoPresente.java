public class EmbrulhoPresente extends ItemDecorator {
    public EmbrulhoPresente(Item itemDecorado) {
        super(itemDecorado);
    }

    @Override
    public String getNome() {
        return itemDecorado.getNome() + " (Com Embrulho)";
    }

    @Override
    public double getPreco() {
        return itemDecorado.getPreco() + 5.00; //Adiciona R$ 5,00
    }
}