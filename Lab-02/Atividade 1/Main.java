public class Main {
    public static void main(String[] args) {
        System.out.println("----- FUNCIONAMENTO SAMSUNG ----\n");

        //Primeiro: Testando a Fabrica + Singleton da Samsung
        FabricanteCelular samsung = Samsung.getInstancia(); 

        Celular cel1 = samsung.constroiCelular("Galaxy 8");
        Celular cel2 = samsung.constroiCelular("Galaxy 20");

        //Testando se funcionam
        if(cel1 != null) {
            cel1.fazLigacao();
            cel1.tiraFoto();
        }
        System.out.println("\n"); //Só para dar um espaço entre os testes

        if(cel2 != null) {
            cel2.fazLigacao();
            cel2.tiraFoto();
        }

        System.out.println("\n------------------------------------- \n");
        System.out.println("----- FUNCIONAMENTO APPLE ----\n");


        //Segundo: Testando a Fabrica + Singleton da Apple
        FabricanteCelular apple = Apple.getInstance(); 

        Celular cel3 = apple.constroiCelular("Iphone S");
        Celular cel4 = apple.constroiCelular("Iphone X");

        //Testando se funcionam
        if(cel3 != null) {
            cel3.fazLigacao();
            cel3.tiraFoto();
        }
        System.out.println("\n"); //Só para dar um espaço entre os testes

        if(cel4 != null) {
            cel4.fazLigacao();
            cel4.tiraFoto();
        }
    }
}