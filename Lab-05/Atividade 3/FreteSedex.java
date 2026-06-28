public class FreteSedex implements FreteStrategy {
    @Override
    public double calcular(double totalCompra) {
        return 35.00; //Valor fixo para o Sedex (mais rápido -> mais caro)
    }
}