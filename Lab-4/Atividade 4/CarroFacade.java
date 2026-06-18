public class CarroFacade {
    private Motor motor;
    private CintoSeguranca cinto;
    private Porta porta;
    private Farol farol;
    private Radio radio;

    public CarroFacade() {
        this.motor = new Motor();
        this.cinto = new CintoSeguranca();
        this.porta = new Porta();
        this.farol = new Farol();
        this.radio = new Radio();
    }

    //Método simplificado para iniciar uma corrida
    public void dirigir(String estacaoPreferida) {
        System.out.println("==== INICIANDO CORRIDA ====");
        motor.ligar();
        porta.trancar();
        cinto.travar();
        farol.acender();
        radio.ligar();
        radio.sintonizar(estacaoPreferida);
        System.out.println("===========================\n");
    }

    //Método simplificado para finalizar a corrida
    public void finalizarCorrida() {
        System.out.println("==== FINALIZANDO CORRIDA ====");
        motor.desligar();
        porta.destrancar();
        cinto.destravar();
        farol.apagar();
        radio.desligar();
        System.out.println("=============================");
    }
}