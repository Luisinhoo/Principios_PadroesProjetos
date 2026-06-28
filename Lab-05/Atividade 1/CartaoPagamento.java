public class CartaoPagamento implements PagamentoStrategy {
    @Override
    public void pagar(double total) {
        System.out.printf("Pagamento de R$" + total + " realizado via Cartão de Crédito. Parcelado em 1x.%n");
    }
}