public class AvePatoAdapter  implements Ave{
    private Pato pato;
    public AvePatoAdapter(Pato pato) {//Finge ser uma ave comum, mas na verdade é um pato
        this.pato = pato;
    }

    @Override
    public void voar() {
        pato.voar(); //O comando voar passa direto para o pato, que tem sua própria implementação de voar
    }

    @Override
    public void emitirSom() {
        pato.grasnar(); //Quando o sistema pede pra emitirSom, o adaptador faz o pato grasnar!
    }

}