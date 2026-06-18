public class Queijo extends PizzaDecorator {
    public Queijo(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescricao() {
        String descricaoSemQueijo = super.getDescricao();
        return descricaoSemQueijo + ", Queijo";
    }

    @Override
    public double getCusto() {
        double custoSemQueijo = super.getCusto();
        return custoSemQueijo + 20.0; //O queijo custa 20 reais
    }
}