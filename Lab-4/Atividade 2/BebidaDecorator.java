public abstract class BebidaDecorator implements Bebida {
    protected Bebida bebida; //Composição: Bebida decorada

    public BebidaDecorator(Bebida bebida) {
        this.bebida = bebida;
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao(); //Delegação para a bebida decorada
    }

    @Override
    public double calculaCusto() {
        return bebida.calculaCusto(); //Delegação para a bebida decorada
    }
}