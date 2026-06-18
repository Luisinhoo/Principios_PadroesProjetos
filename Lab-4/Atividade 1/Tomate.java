public class Tomate extends PizzaDecorator{
    public Tomate(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescricao() {
        String descricaoSemTomate = super.getDescricao();
        return descricaoSemTomate + ", Tomate";
    }

    @Override
    public double getCusto() {
        double custoSemTomate = super.getCusto();
        return custoSemTomate + 20.0; //O tomate custa 20 reais
    }
}