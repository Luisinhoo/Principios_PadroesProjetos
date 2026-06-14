public class AvePavaoAdapter implements Ave {
    private Pavao pavao;

    //Recebe o pavão real que será adaptado
    public AvePavaoAdapter(Pavao pavao) {
        this.pavao = pavao;
    }

    @Override
    public void voar() {
        //Como pavão não voa, o adaptador avisa
        System.out.println("O pavão tenta voar, mas não consegue!!!");
    }

    @Override
    public void emitirSom() {
        pavao.cantar(); //Quando o sistema pede pra emitirSom, o adaptador faz o pavão cantar!
    }
}