import java.util.Scanner; //Para a função Scanner();

public class AutomacaoResidencial {
    public static void main(String[] args) {
        //UTF-8 para garantir que tudo saia perfeitamente sem bugar os acentos
        Scanner teclado = new Scanner(System.in, "UTF-8");
        
        //Criamos o nosso painel simplificado (Fachada)
        CasaFacade controleCasa = new CasaFacade();

        System.out.println("=========================================");
        System.out.println("    SISTEMA SMART HOME DO LUÍS v1.0   ");
        System.out.println("=========================================");

        int opcao;
        do {
            System.out.println("\n[PAINEL DE CONTROLE CENTRAL]");
            System.out.println("1. Ativar Modo Cinema");
            System.out.println("2. Ativar Modo Descanso");
            System.out.println("3. Ativar Modo Sair de Casa");
            System.out.println("0. Desconectar do Painel");
            System.out.print("Escolha uma rotina automatizada: ");
            opcao = teclado.nextInt();

            switch(opcao) {
                case 1:
                    controleCasa.modoCinema(); //Dispara a fachada
                    break;
                case 2:
                    controleCasa.modoDescanso(); //Dispara a fachada
                    break;
                case 3:
                    controleCasa.modoSairDeCasa(); //Dispara a fachada
                    break;
                case 0:
                    System.out.println("\nDesconectando do painel residencial com segurança...");
                    break;
                default:
                    System.out.println("\nComando não reconhecido pelo hub central.");
                    break;
            }
        } while(opcao != 0);

        System.out.println("=========================================");
        System.out.println("Painel finalizado. Tenha um ótimo dia!");
        System.out.println("=========================================");
        teclado.close();
    }
}