public class Main {
    public static void main(String[] args) {
        System.out.println("----- DEMONSTRAÇÃO DO PADRÃO ADAPTER (AVES) -----\n");

        //Criamos os animais nas suas formas nativas (classes concretas)
        Pato domestico = new PatoDomestico();
        Pavao azul = new PavaoAzul();

        //Criamos as "tomadas adaptadoras" para transformá-los em Ave
        Ave AvePatoAdapter = new AvePatoAdapter(domestico);
        Ave AvePavaoAdapter = new AvePavaoAdapter(azul);

        //Testando o Pato adaptado como se fosse uma Ave comum
        System.out.println("=== TESTANDO O PATO ADAPTADO ===");
        AvePatoAdapter.emitirSom(); //Vai chamar o .grasnar() por baixo dos panos!
        AvePatoAdapter.voar();
        
        System.out.println("\n-------------------------------------------------\n");

        //Testando o Pavão adaptado como se fosse uma Ave comum
        System.out.println("=== TESTANDO O PAVÃO ADAPTADO ===");
        AvePavaoAdapter.emitirSom(); //Vai chamar o .cantar() por baixo dos panos!
        AvePavaoAdapter.voar();      //Vai avisar que pavão não consegue voar!
    }
}