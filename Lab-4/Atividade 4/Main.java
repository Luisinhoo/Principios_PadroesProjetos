public class Main {
    public static void main(String[] args) {
        //Criamos o carro (a Fachada)
        CarroFacade carro = new CarroFacade();

        carro.dirigir("98.1 FM");

        System.out.println("... Dirigindo pelas ruas da cidade ...\n");

        carro.finalizarCorrida();
    }
}