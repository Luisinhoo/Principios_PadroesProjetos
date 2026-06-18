public class Ovo extends PizzaDecorator {
    public Ovo(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescricao() {
        String descricaoSemOvo = super.getDescricao();
        return descricaoSemOvo + ", Ovo";
    }

    @Override
    public double getCusto() {
        double custoSemOvo = super.getCusto();
        return custoSemOvo + 30.0; //O ovo custa 30 reais
    }
}