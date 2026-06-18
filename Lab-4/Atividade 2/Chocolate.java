public class Chocolate extends BebidaDecorator {
    public Chocolate(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", Chocolate";
    }

    @Override
    public double calculaCusto() {
        return bebida.calculaCusto() + 2.50; //Preço do chocolate
    }
}