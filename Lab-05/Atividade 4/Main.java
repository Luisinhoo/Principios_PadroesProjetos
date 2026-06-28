import java.util.Scanner; //Para a função Scanner

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CarrinhoCompras carrinho = new CarrinhoCompras();
        
        NotificacaoObserver email = new EmailNotificacao();
        NotificacaoObserver sms = new SMSNotificacao();

        carrinho.registrarObserver(email);
        carrinho.registrarObserver(sms);

        Item livro = new Item("O Romance dos Três Reinos", 300.00);
        Item album = new Item("Álbum Arirang - BTS", 156.93);

        //=== QUESTÃO 4: Aplicando os Decorators ===
        //Colocando embrulho de presente no livro
        Item livroDecorado = new EmbrulhoPresente(livro);
        
        //Colocando SEGURO E EMBRULHO no álbum (Decoração dupla!)
        Item albumDecorado = new EmbrulhoPresente(new SeguroEletronico(album));
        //==================================================

        //Adicionando os itens já decorados no carrinho
        carrinho.adicionaItem(livroDecorado);
        carrinho.adicionaItem(albumDecorado);

        carrinho.removeItem(albumDecorado);

        //1º MENU: SELEÇÃO DE FRETE (Questão 2)
        System.out.println("\n=== SELECIONE O TIPO DE FRETE ===");
        System.out.println("1 - Frete Normal (R$ 15,00)");
        System.out.println("2 - Frete Sedex (R$ 35,00)");
        System.out.print("Digite a opção desejada: ");
        int opcaoFrete = scanner.nextInt();

        FreteStrategy freteEscolhido = null;

        switch(opcaoFrete) {
            case 1:
                freteEscolhido = new FreteNormal();
                break;
            case 2:
                freteEscolhido = new FreteSedex();
                break;
            default:
                System.out.println("Opção de frete inválida! Usando Frete Normal por padrão.");
                freteEscolhido = new FreteNormal();
                break;
        }

        //2º MENU: SELEÇÃO DE PAGAMENTO (Questão 1)
        System.out.println("\n=== SELECIONE A FORMA DE PAGAMENTO ===");
        System.out.println("1 - Pix");
        System.out.println("2 - Cartão de Crédito");
        System.out.println("3 - Boleto Bancário");
        System.out.print("Digite a opção desejada: ");
        int opcaoPagamento = scanner.nextInt();
        
        PagamentoStrategy estrategiaEscolhida = null;

        switch(opcaoPagamento) {
            case 1:
                estrategiaEscolhida = new PixPagamentoNovo();
                break;
            case 2:
                estrategiaEscolhida = new CartaoPagamentoNovo();
                break;
            case 3:
                estrategiaEscolhida = new BoletoPagamentoNovo();
                break;
            default:
                System.out.println("Opção inválida! Compra cancelada.");
                break;
        }

        if(estrategiaEscolhida != null) {
            carrinho.realizaPagamento(estrategiaEscolhida, freteEscolhido);
        }

        scanner.close();
    }
}