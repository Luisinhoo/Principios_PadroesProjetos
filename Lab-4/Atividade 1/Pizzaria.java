import java.util.Scanner; //Para a função Scanner()

public class Pizzaria {
    public static void main(String[] args) {
        //UTF-8 para garantir que tudo saia perfeitamente sem bugar os acentos
        Scanner teclado = new Scanner(System.in, "UTF-8");

        System.out.println("=========================================");
        System.out.print("Digite o seu nome: ");
        String nomeCliente = teclado.nextLine();

        System.out.println("\nBem Vinde à Pizzaria do Luís Sr/Sra " + nomeCliente + "!");
        System.out.println("=========================================");

        System.out.println("Escolha a massa da sua pizza:");
        System.out.println("1. Massa Fina (R$ 20,00)");
        System.out.println("2. Massa Espessa (R$ 25,00)");
        System.out.print("Digite a opção desejada: ");
        int opcaoMassa = teclado.nextInt();

        Pizza minhaPizza;
        if(opcaoMassa == 2) {
            minhaPizza = new MassaEspessaPizza();
        } else {
            minhaPizza = new MassaFinaPizza(); //Caso o usuário digite 1 ou algo inválido
        }
        System.out.println("\nBase da pizza criada!");

        int opcaoTopping;
        do {
            System.out.println("\n--- ADICIONAR INGREDIENTES (TOPPINGS) ---");
            System.out.println("1. Adicionar Queijo (+ R$ 5,00)");
            System.out.println("2. Adicionar Tomate (+ R$ 3,00)");
            System.out.println("3. Adicionar Ovo (+ R$ 2,00)");
            System.out.println("0. Finalizar Pizza e ir para o Caixa");
            System.out.print("Escolha o ingrediente: ");
            opcaoTopping = teclado.nextInt();

            switch(opcaoTopping) {
                case 1:
                    //O Decorator embrulha a pizza atual adicionando o Queijo
                    minhaPizza = new Queijo(minhaPizza);
                    System.out.println("[Sucesso] Queijo adicionado!");
                    break;
                case 2:
                    //O Decorator embrulha a pizza atual adicionando o Tomate
                    minhaPizza = new Tomate(minhaPizza);
                    System.out.println("Tomate adicionado!");
                    break;
                case 3:
                    //O Decorator embrulha a pizza atual adicionando o Ovo
                    minhaPizza = new Ovo(minhaPizza);
                    System.out.println("Ovo adicionado!");
                    break;
                case 0:
                    System.out.println("\nFechando o seu pedido...");
                    break;
                default:
                    System.out.println("\nOpção inválida! Escolha de 0 a 3.");
                    break;
            }
        } while(opcaoTopping != 0);

        System.out.println("\n=========================================");
        System.out.println("           RESUMO DO SEU PEDIDO          ");
        System.out.println("=========================================");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Sua Pizza: " + minhaPizza.getDescricao());
        System.out.printf("Valor Total: R$ %.2f\n", minhaPizza.getCusto());
        System.out.println("=========================================");

        //Pagamento e Troco
        double valorPago = 0.0;
        do {
            System.out.print("Digite o valor pago pelo cliente (R$): ");
            valorPago = teclado.nextDouble();
            
            if (valorPago < minhaPizza.getCusto()) {
                System.out.printf("Dinheiro insuficiente! Falta R$ %.2f. Tente novamente.\n", (minhaPizza.getCusto() - valorPago));
            }
        } while(valorPago < minhaPizza.getCusto());

        double troco = valorPago - minhaPizza.getCusto();

        System.out.println("\n=========================================");
        System.out.printf("Valor Pago: R$ %.2f\n", valorPago);
        System.out.printf("Troco: R$ %.2f\n", troco);
        System.out.println("=========================================");
        System.out.println("Bom apetite e volte sempre <3");
        System.out.println("=========================================");

        teclado.close();
    }
}