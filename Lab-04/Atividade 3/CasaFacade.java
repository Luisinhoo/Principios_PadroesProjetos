public class CasaFacade {
    //A fachada guarda as referências de todos os aparelhos
    private Luz luz;
    private ArCondicionado ar;
    private Televisao tv;
    private Som som;

    //Construtor inicializa todos os subsistemas automaticamente
    public CasaFacade() {
        this.luz = new Luz();
        this.ar = new ArCondicionado();
        this.tv = new Televisao();
        this.som = new Som();
    }

    //Modo Cinema: Liga tudo e configura o entretenimento
    public void modoCinema() {
        System.out.println("\n--- ATIVANDO MODO CINEMA ---");
        luz.ligar();
        tv.ligar();
        tv.setCanal(150); //Canal de Filmes/Streaming
        som.ligar();
        som.setVolume(45);
        ar.ligar();
        ar.setTemperatura(21);
        System.out.println("----------------------------");
    }

    //Modo Sair de Casa: Desliga absolutamente tudo por segurança
    public void modoSairDeCasa() {
        System.out.println("\n--- ATIVANDO MODO SAIR DE CASA ---");
        luz.desligar();
        tv.desligar();
        som.desligar();
        ar.desligar();
        System.out.println("----------------------------------");
    }

    //Modo Descanso: Apaga as luzes, liga o ar confortável e o som baixinho
    public void modoDescanso() {
        System.out.println("\n--- ATIVANDO MODO DESCANSO ---");
        luz.desligar();
        ar.ligar();
        ar.setTemperatura(24);
        som.ligar();
        som.setVolume(12); //Música ambiente calma
        tv.desligar();     //Garante que a TV fique desligada para descansar
        System.out.println("------------------------------");
    }
}