public class BoletoPagamentoNovo implements PagamentoStrategy {
    @Override
    public void pagar(double total) {
        System.out.printf("Boleto gerado no valor de R$" + total + "%n");
    }
}