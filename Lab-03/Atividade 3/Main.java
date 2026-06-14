import java.util.Scanner; //Para a função Scanner

public class Main {
    public static void main(String[] args) {
        //UTF-8 é para evitar que letras com acentos e caracteres especiais se transformem em símbolos estranhos
        Scanner teclado = new Scanner(System.in, "UTF-8");
        InterfacePadaria padaria = new PadariaAdapter();

        System.out.println("=========================================");
        System.out.print("Por favor, digite o seu nome: ");
        String nomeCliente = teclado.nextLine();

        System.out.println("\nBem Vinde a Padaria do Luís Sr/Sra " + nomeCliente + "!");
        System.out.println("=========================================");

        //Variáveis para acumular as quantidades de cada item que o cliente escolher
        int qtdPao = 0;
        int qtdCafe = 0;
        int qtdPaoQueijo = 0;
        int qtdRosca = 0;
        int qtdSalgado = 0;

        int opcaoMenu;

        //Loop para o cliente escolher os itens um por um
        do {
            System.out.println("\n--- PRODUTOS DISPONÍVEIS ---");
            System.out.println("1. Pão (R$ 0,50)");
            System.out.println("2. Café (R$ 1,50)");
            System.out.println("3. Pão de Queijo (R$ 1,00)");
            System.out.println("4. Rosca (R$ 2,50)");
            System.out.println("5. Salgado (R$ 5,00)");
            System.out.println("0. Finalizar Pedido e Ir para o Pagamento");
            System.out.print("Escolha o produto que deseja adicionar: ");
            
            opcaoMenu = teclado.nextInt();

            //Switch para pedir a quantidade baseada no item escolhido
            switch(opcaoMenu) {
                case 1:
                    System.out.print("Quantos Pães você deseja? ");
                    qtdPao += teclado.nextInt(); //Soma caso ele escolha pão mais de uma vez
                    System.out.println("[Sucesso] Pão adicionado ao carrinho!");
                    break;
                case 2:
                    System.out.print("Quantos Copos de Café você deseja? ");
                    qtdCafe += teclado.nextInt();
                    System.out.println("[Sucesso] Café adicionado ao carrinho!");
                    break;
                case 3:
                    System.out.print("Quantos Pães de Queijo você deseja? ");
                    qtdPaoQueijo += teclado.nextInt();
                    System.out.println("[Sucesso] Pão de Queijo adicionado ao carrinho!");
                    break;
                case 4:
                    System.out.print("Quantas Roscas você deseja? ");
                    qtdRosca += teclado.nextInt();
                    System.out.println("[Sucesso] Rosca adicionada ao carrinho!");
                    break;
                case 5:
                    System.out.print("Quantos Salgados você deseja? ");
                    qtdSalgado += teclado.nextInt();
                    System.out.println("[Sucesso] Salgado adicionado ao carrinho!");
                    break;
                case 0:
                    System.out.println("\nFechando carrinho de compras...");
                    break;
                default:
                    System.out.println("\n[Erro] Opção inválida! Escolha um número de 0 a 5.");
                    break;
            }

        } while(opcaoMenu != 0); //Continua no menu até digitar 0

        //Depois que sai do loop, o adaptador processa o cálculo final com a regra de descontos do Luís
        double valorFinal = padaria.processarCompra(qtdPao, qtdCafe, qtdPaoQueijo, qtdRosca, qtdSalgado);

        //Cálculo do valor sem desconto apenas para mostrar a diferença na notinha
        double valorSemDesconto = (qtdPao * 0.50) + (qtdCafe * 1.50) + (qtdPaoQueijo * 1.00) + (qtdRosca * 2.50) + (qtdSalgado * 5.00);
        double descontoObtido = valorSemDesconto - valorFinal;

        //Exibição do Cupom Fiscal/Notinha
        System.out.println("\n=========================================");
        System.out.println("           NOTINHA DA PADARIA            ");
        System.out.println("=========================================");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Itens Pedidos:");

        if(qtdPao > 0)       System.out.println("- Pães: " + qtdPao);
        if(qtdCafe > 0)      System.out.println("- Cafés: " + qtdCafe);
        if(qtdPaoQueijo > 0) System.out.println("- Pães de Queijo: " + qtdPaoQueijo);
        if(qtdRosca > 0)     System.out.println("- Roscas: " + qtdRosca);
        if(qtdSalgado > 0)   System.out.println("- Salgados: " + qtdSalgado);

        System.out.println("-----------------------------------------");
        System.out.printf("Valor Bruto: R$ %.2f\n", valorSemDesconto);
        System.out.printf("Desconto Aplicado: R$ %.2f\n", descontoObtido);
        System.out.printf("VALOR TOTAL A PAGAR: R$ %.2f\n", valorFinal);
        System.out.println("=========================================");

        //FLUXO DE PAGAMENTO E CÁLCULO DE TROCO
        double valorPago = 0.0;
        do{
            System.out.print("Digite o valor pago pelo cliente (R$): ");
            valorPago = teclado.nextDouble();
            
            if(valorPago < valorFinal) {
                System.out.printf("[Erro] Dinheiro insuficiente! Falta R$ %.2f. Tente novamente.\n", (valorFinal - valorPago));
            }
        } while(valorPago < valorFinal); //Prende o caixa no loop se o cliente der menos dinheiro do que deve

        double troco = valorPago - valorFinal;

        //Finalização da venda com entrega do troco
        System.out.println("\n=========================================");
        System.out.printf("Valor Pago: R$ %.2f\n", valorPago);
        System.out.printf("TROCO: R$ %.2f\n", troco);
        System.out.println("=========================================");
        System.out.println("Obrigado pela preferência, volte sempre!");
        System.out.println("=========================================");

        teclado.close();
    }
}