public class MassaFinaPizza implements Pizza {
    @Override
    public String getDescricao() {
        return "Pizza de Massa Fina";
    }

    @Override
    public double getCusto() {
        return 85.00; //Preço base da massa fina
    }
}