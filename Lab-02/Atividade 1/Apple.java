public class Apple implements FabricanteCelular {

    //-- AQUI COMEÇA O SINGLETON --
    //Uma variável privada e estática que guarda a ÚNICA instância da Apple
    private static Apple instanciaUnica;

    //Construtor PRIVADO: faz com que ninguém na Main consiga dar "new Apple()"
    private Apple(){

    }
    
    //Método público para a Main conseguir pegar a nossa fábrica
    public static Apple getInstance(){
        if(instanciaUnica == null){
            instanciaUnica = new Apple(); //Só cria se ainda não existir
        }
        return instanciaUnica;
    }
    //-- FIM DO SINGLETON --

    //--- AQUI COMEÇA O PADRÃO FÁBRICA ---
    //Esse é o método do contrato FabricanteCelular que criei para contruir celulares
    @Override
    public Celular constroiCelular(String modelo) {
        //.equals() para comparar Strings
        if(modelo.equals("Iphone S")) {
            return new IphoneS(); //Cria e devolve um Iphone S
        }
        else if(modelo.equals("Iphone X")){
            return new IphoneX(); //Cria e devolve um Iphone X
        }
        //Se passarem um modelo que a Apple não faz
        return null; 
    }
}