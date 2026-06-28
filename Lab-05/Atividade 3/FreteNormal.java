public class FreteNormal implements FreteStrategy {
    @Override
    public double calcular(double totalCompra) {
        return 15.00; //Valor fixo para o frete normal
    }
}