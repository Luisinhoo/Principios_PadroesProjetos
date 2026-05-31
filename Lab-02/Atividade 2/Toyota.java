public class Toyota implements IVehicleMaker {

    //--- AQUI COMEÇA O PADRÃO SINGLETON ---
    //Guardamos a única instância da fábrica Toyota numa variável estática privada
    private static Toyota instanciaUnica;

    //Construtor privado: garante que ninguém na Main consiga fazer "new Toyota()"
    private Toyota() {
    }

    //Método público para permitir que o sistema pegue a instância única da fábrica
    public static Toyota getInstance() {
        if(instanciaUnica == null) {
            instanciaUnica = new Toyota(); //Só cria a se inda não existir
        }
        return instanciaUnica;
    }
    //--- FIM DO SINGLETON ---

    // --- AQUI COMEÇA O PADRÃO FÁBRICA (FACTORY METHOD) ---
    @Override
    public IVehicle makeVehicle(String modelo) {
        
        return switch (modelo) {
            case "Corolla" -> new Corolla(); //Fabrica e devolve um Corolla
            case "Hilux"   -> new Hilux();  //Fabrica e devolve uma Hilux
            case "Etios"   -> new Etios();  //Fabrica e devolve um Etios
            default        -> null;
        };
    }
    //--- FIM DO PADRÃO FÁBRICA ---
}