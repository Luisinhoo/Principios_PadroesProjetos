import java.util.ArrayList; //Importa a classe que implementa a lista dinamicamente
import java.util.List; //Importa a interface que define o comportamento da lista

public class CarrinhoCompras {
    private List<Item> itens;

    public CarrinhoCompras() {
        this.itens = new ArrayList<>();
    }

    public void adicionaItem(Item item) {
        this.itens.add(item);
        System.out.println(item.getNome() + " adicionado ao carrinho.");
    }

    public void removeItem(Item item) {
        if(this.itens.remove(item)) {
            System.out.println(item.getNome() + " removido do carrinho.");
        }
    }

    public double calculaTotal() {
        double total = 0;
        for(Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    //=== NOVO MÉTODO SOLICITADO NESSA QUESTÃO===
    //Ele recebe QUALQUER tipo de frete e calcula o valor dele
    public double calculaFrete(FreteStrategy estrategiaFrete) {
        double totalProdutos = calculaTotal();
        return estrategiaFrete.calcular(totalProdutos);
    }

    //Atualizamos este método para incluir a estratégia de frete no fechamento
    public void realizaPagamento(PagamentoStrategy estrategiaPagamento, FreteStrategy estrategiaFrete) {
        double totalProdutos = calculaTotal();
        double valorFrete = calculaFrete(estrategiaFrete); //Usando o novo método
        double totalGeral = totalProdutos + valorFrete;    //Soma dos produtos + frete
        
        System.out.println("\n--- Fechando o Carrinho ---");
        System.out.printf("Total dos itens: R$ %.2f%n", totalProdutos);
        System.out.printf("Valor do frete:  R$ %.2f%n", valorFrete);
        System.out.printf("Total da compra: R$ %.2f%n", totalGeral);
        
        //Passa o total geral (com o frete embutido) para a estratégia de pagamento
        estrategiaPagamento.pagar(totalGeral);
    }
}