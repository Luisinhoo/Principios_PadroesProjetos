import java.util.ArrayList; //Importa a classe que implementa a lista dinamicamente
import java.util.List; //Importa a interface que define o comportamento da lista

public class CarrinhoCompras {
    private List<Item> itens;
    
    //=== NOVO PARA A QUESTÃO 3: Lista de inscritos do canal ===
    private List<NotificacaoObserver> observadores;

    public CarrinhoCompras() {
        this.itens = new ArrayList<>();
        this.observadores = new ArrayList<>(); //Inicializa a lista
    }

    //=== MÉTODOS DO PADRÃO OBSERVER ===
    public void registrarObserver(NotificacaoObserver observer) {
        this.observadores.add(observer);
    }

    public void removerObserver(NotificacaoObserver observer) {
        this.observadores.remove(observer);
    }

    public void notificarObservers(String mensagem) {
        for(NotificacaoObserver observer : observadores) {
            observer.atualizar(mensagem); // Avisa cada um da lista
        }
    }
    // ===================================

    public void adicionaItem(Item item) {
        this.itens.add(item);
        System.out.println("\n[Carrinho] " + item.getNome() + " adicionado ao carrinho.");
        
        notificarObservers("O produto '" + item.getNome() + "' entrou no carrinho!");
    }

    public void removeItem(Item item) {
        if(this.itens.remove(item)) {
            System.out.println("\n[Carrinho] " + item.getNome() + " removido do carrinho.");
            
            notificarObservers("O produto '" + item.getNome() + "' foi tirado do carrinho.");
        }
    }

    public double calculaTotal() {
        double total = 0;
        for(Item item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public double calculaFrete(FreteStrategy estrategiaFrete) {
        double totalProdutos = calculaTotal();
        return estrategiaFrete.calcular(totalProdutos);
    }

    public void realizaPagamento(PagamentoStrategy estrategiaPagamento, FreteStrategy estrategiaFrete) {
        double totalProdutos = calculaTotal();
        double valorFrete = calculaFrete(estrategiaFrete);
        double totalGeral = totalProdutos + valorFrete;    
        
        System.out.println("\n--- Fechando o Carrinho ---");
        System.out.printf("Total dos itens: R$ %.2f%n", totalProdutos);
        System.out.printf("Valor do frete:  R$ %.2f%n", valorFrete);
        System.out.printf("Total da compra: R$ %.2f%n", totalGeral);
        
        estrategiaPagamento.pagar(totalGeral);
    }
}