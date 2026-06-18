import java.util.Scanner; //Para a função Scanner();

public class Cafeteria {
    public static void main(String[] args) {
        //UTF-8 para garantir que tudo saia perfeitamente sem bugar os acentos
        Scanner teclado = new Scanner(System.in, "UTF-8");

        System.out.println("=========================================");
        System.out.print("Por favor, digite o seu nome: ");
        String nomeCliente = teclado.nextLine();

        System.out.println("\nBem Vinde à Cafeteria do Luís Sr/Sra " + nomeCliente + "!");
        System.out.println("=========================================");

        System.out.println("Escolha a base do seu café:");
        System.out.println("1. Espresso (R$ 4,50)");
        System.out.println("2. Decaf (R$ 5,00)");
        System.out.print("Digite a opção desejada: ");
        int opcaoBase = teclado.nextInt();

        Bebida meuCafe;
        if(opcaoBase == 2) {
            meuCafe = new Decaf();
        } else {
            meuCafe = new Espresso(); //Cadrão caso digite 1 ou qualquer outra coisa
        }
        System.out.println("\nBase do café preparada!");

        int opcaoDecorador;
        do {
            System.out.println("\n--- ADICIONAR COMPLEMENTOS ---");
            System.out.println("1. Leite (+ R$ 1,50)");
            System.out.println("2. Canela (+ R$ 0,50)");
            System.out.println("3. Chocolate (+ R$ 2,00)");
            System.out.println("0. Concluir bebida e ir para o Pagamento");
            System.out.print("Escolha o complemento que deseja adicionar: ");
            opcaoDecorador = teclado.nextInt();

            switch(opcaoDecorador) {
                case 1:
                    meuCafe = new Leite(meuCafe); //Embrulha adicionando leite
                    System.out.println("Leite adicionado!");
                    break;
                case 2:
                    meuCafe = new Canela(meuCafe); //Embrulha adicionando canela
                    System.out.println("Canela adicionada!");
                    break;
                case 3:
                    meuCafe = new Chocolate(meuCafe); //Embrulha adicionando chocolate
                    System.out.println("Chocolate adicionado!");
                    break;
                case 0:
                    System.out.println("\nFinalizando o preparo da bebida...");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente de 0 a 3.");
                    break;
            }
        } while(opcaoDecorador != 0);

        double totalConta = meuCafe.calculaCusto();

        System.out.println("\n=========================================");
        System.out.println("           RECIBO DA CAFETERIA           ");
        System.out.println("=========================================");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Pedido: " + meuCafe.getDescricao());
        System.out.printf("Total a pagar: R$ %.2f\n", totalConta);
        System.out.println("=========================================");

        double valorPago = 0.0;
        do {
            System.out.print("Digite o valor em dinheiro entregue pelo cliente (R$): ");
            valorPago = teclado.nextDouble();
            
            if(valorPago < totalConta) {
                System.out.printf("Valor insuficiente! Faltam R$ %.2f. Tente novamente.\n", (totalConta - valorPago));
            }
        } while(valorPago < totalConta);

        double troco = valorPago - totalConta;

        System.out.println("\n=========================================");
        System.out.printf("Valor Pago: R$ %.2f\n", valorPago);
        System.out.printf("Troco: R$ %.2f\n", troco);
        System.out.println("=========================================");
        System.out.println("Café uentinho saindo! Volte sempre<3");
        System.out.println("=========================================");

        teclado.close();
    }
}