public class Decaf implements Bebida {
    @Override
    public String getDescricao() {
        return "Decaf";
    }

    @Override
    public double calculaCusto() {
        return 5.00; //Preço do Decaf
    }
}