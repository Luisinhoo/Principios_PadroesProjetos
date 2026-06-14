import java.util.Scanner; //Para a função Scanner

public class Main {
    public static void main(String[] args) {
        //A função é Scanner para ler o teclado e o Adapter da calculadora
        Scanner teclado = new Scanner(System.in);
        CalculadoraDecimal calc = new CalculadoraAdapter();
        
        int opcao;

        do {
            //Menu do Usuário para ele escolher a operação que deseja fazer
            System.out.println("\n===== CALCULADORA ADAPTER =====");
            System.out.println("1. Somar");
            System.out.println("2. Subtrair");
            System.out.println("3. Multiplicar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = teclado.nextInt(); //Lê a opção que o usuário escolheu

            //Se o usuário escolher uma das três operações válidas, pede os números e chama o método correspondente do Adapter
            if(opcao >= 1 && opcao <= 3) {
                System.out.print("Digite o primeiro número: ");
                int num1 = teclado.nextInt(); //Lê o primeiro número inteiro

                System.out.print("Digite o segundo número: ");
                int num2 = teclado.nextInt(); //Lê o segundo número inteiro

                System.out.println("\n---------------------------------");
                
                //O switch escolhe qual método do nosso Adapter chamar
                switch(opcao) {
                    case 1:
                        int soma = calc.somar(num1, num2);
                        System.out.println("Resultado da Soma: " + soma);
                        break;
                    case 2:
                        int sub = calc.subtrair(num1, num2);
                        System.out.println("Resultado da Subtração: " + sub);
                        break;
                    case 3:
                        int mult = calc.multiplicar(num1, num2);
                        System.out.println("Resultado da Multiplicação: " + mult);
                        break;
                }
                System.out.println("---------------------------------");
            } else if(opcao != 0) {
                System.out.println("\n[Erro] Opção inválida! Tente novamente.");
            }

        } while(opcao != 0); //O programa continua rodando até o usuário digitar 0

        System.out.println("\nCalculadora encerrada. Até loguinho !!!!");
        teclado.close(); //Fecha o leitor do teclado de forma segura
    }
}