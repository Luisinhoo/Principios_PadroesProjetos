public abstract class PizzaDecorator implements Pizza {
    protected Pizza pizzaDecorada; //A pizza que está sendo feita

    public PizzaDecorator(Pizza pizza) {
        this.pizzaDecorada = pizza;
    }

    @Override
    public String getDescricao() {
        return pizzaDecorada.getDescricao();
    }

    @Override
    public double getCusto() {
        return pizzaDecorada.getCusto();
    }
}