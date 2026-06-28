import java.util.ArrayList; //Importa a classe que implementa a lista dinamicamente
import java.util.List; //Importa a interface que define o comportamento da lista

public class CarrinhoCompras {
    private List<Item> itens; //Lista para guardar os itens do carrinho

    public CarrinhoCompras() {
        this.itens = new ArrayList<>();
    }

    //Adiciona um item ao carrinho
    public void adicionaItem(Item item) {
        this.itens.add(item);
        System.out.println(item.getNome() + " adicionado ao carrinho.");
    }

    //Remove um item do carrinho
    public void removeItem(Item item) {
        if(this.itens.remove(item)) {
            System.out.println(item.getNome() + " removido do carrinho.");
        }
    }

    //Soma o preço de todos os itens
    public double calculaTotal() {
        double total = 0;
        for(Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    //O pulo do gato: recebe QUALQUER estratégia que siga o contrato
    public void realizaPagamento(PagamentoStrategy estrategiaPagamento) {
        double total = calculaTotal();
        System.out.println("\n--- Fechando o Carrinho ---");
        System.out.printf("Total da compra: R$ %.2f%n", total);
        
        //Delega a responsabilidade do pagamento para a estratégia escolhida
        estrategiaPagamento.pagar(total);
    }
}