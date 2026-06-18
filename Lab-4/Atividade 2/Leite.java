public class Leite extends BebidaDecorator {
    public Leite(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + ", Leite";
    }

    @Override
    public double calculaCusto() {
        return bebida.calculaCusto() + 1.50; //Preço do leite
    }
}