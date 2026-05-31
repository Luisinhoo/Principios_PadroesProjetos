public class Main {
    public static void main(String[] args) {
        System.out.println("----- FUNCIONAMENTO DAS FÁBRICAS DE VEÍCULOS -----\n");

        //Primeiro: TESTANDO A FÁBRICA TOYOTA (Usando Singleton)
        IVehicleMaker toyota = Toyota.getInstance(); 

        //Pedindo os carros da Toyota pelo Padrão Fábrica (Factory)
        IVehicle carro1 = toyota.makeVehicle("Corolla");
        IVehicle carro2 = toyota.makeVehicle("Hilux");
        IVehicle carro3 = toyota.makeVehicle("Etios");

        System.out.println("=== TESTANDO TOYOTA ===");
        if(carro1 != null) {
            carro1.start();
            carro1.drive();
            carro1.stop();
        }
        System.out.println("\n"); //Só para dar um espaço entre os testes

        if(carro2 != null) {
            carro2.start();
            carro2.drive();
            carro2.stop();
        }
        System.out.println("\n"); //Só para dar um espaço entre os testes

        if (carro3 != null) {
            carro3.start();
            carro3.drive();
            carro3.stop();
        }

        System.out.println("\n--------------------------------------------------\n");

        //Segundo: TESTANDO A FÁBRICA HONDA (Usando Singleton)
        IVehicleMaker honda = Honda.getInstance(); 

        //Pedindo os carros da Honda pelo Padrão Fábrica (Factory)
        IVehicle carro4 = honda.makeVehicle("City");
        IVehicle carro5 = honda.makeVehicle("Civic");
        IVehicle carro6 = honda.makeVehicle("Fit");

        System.out.println("=== TESTANDO HONDA ===");
        if(carro4 != null) {
            carro4.start();
            carro4.drive();
            carro4.stop();
        }
        System.out.println("\n"); //Só para dar um espaço entre os testes

        if(carro5 != null) {
            carro5.start();
            carro5.drive();
            carro5.stop();
        }

        System.out.println("\n"); //Só para dar um espaço entre os testes

        if(carro6 != null) {
            carro6.start();
            carro6.drive();
            carro6.stop();
        }
    }
}