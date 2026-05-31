public class Honda implements IVehicleMaker {

    //--- AQUI COMEÇA O PADRÃO SINGLETON ---
    //Guardamos a única instância da fábrica Honda numa variável estática privada
    private static Honda instanciaUnica;

    //Construtor privado: garante que ninguém na Main consiga fazer "new Honda()"
    private Honda() {
    }

    //Método público para permitir que o sistema pegue a instância única da fábrica
    public static Honda getInstance() {
        if(instanciaUnica == null) {
            instanciaUnica = new Honda(); //Só cria a se inda não existir
        }
        return instanciaUnica;
    }
    //--- FIM DO SINGLETON ---


   //--- AQUI COMEÇA O PADRÃO FÁBRICA (FACTORY METHOD) ---
    @Override
    public IVehicle makeVehicle(String modelo) {
        
        return switch (modelo) {
            case "City" -> new City();   //Fabrica e devolve um City
            case "Civic" -> new Civic();  //Fabrica e devolve um Civic
            case "Fit" -> new Fit();    //Fabrica e devolve um Fit
            default        -> null;
        };
    }
    // --- FIM DO PADRÃO FÁBRICA ---
}