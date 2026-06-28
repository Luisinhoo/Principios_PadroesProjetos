import java.util.Scanner;//Para a função Scanner

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Criando o carrinho de compras e adicionando os itens
        CarrinhoCompras carrinho = new CarrinhoCompras();
        
        Item livro = new Item("O Romance dos Três Reinos", 300.00);
        Item album = new Item("Álbum Arirang - BTS", 156.93);

        carrinho.adicionaItem(livro);
        carrinho.adicionaItem(album);

        //Mostrando as opções de estratégia de pagamento para o usuário
        System.out.println("\n=== SELECIONE A FORMA DE PAGAMENTO ===");
        System.out.println("1 - Pix");
        System.out.println("2 - Cartão de Crédito");
        System.out.println("3 - Boleto Bancário");
        System.out.print("Digite a opção desejada: ");
        
        int opcao = scanner.nextInt();

        //Para guardar a estratégia escolhida
        PagamentoStrategy estrategiaEscolhida = null;

        switch (opcao) {
            case 1:
                estrategiaEscolhida = new PixPagamento();
                break;
            case 2:
                estrategiaEscolhida = new CartaoPagamento();
                break;
            case 3:
                estrategiaEscolhida = new BoletoPagamento();
                break;
            default:
                System.out.println("Opção inválida! Compra cancelada.");
                break;
        }

        //Se a opção for válida, realiza o pagamento com a estratégia escolhida
        if(estrategiaEscolhida != null) {
            carrinho.realizaPagamento(estrategiaEscolhida);
        }

        //Fechando o scanner para boa prática
        scanner.close();
    }
}