public class PixPagamentoNovo implements PagamentoStrategy {
    @Override
    public void pagar(double total){
        System.out.println("Pagamento de R$" + total + " feito via Pix.");
    }
}