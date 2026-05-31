public class Samsung implements FabricanteCelular {

    //--- AQUI COMEÇA O SINGLETON ---
    //Uma variável privada e estática que guarda a ÚNICA instância da Samsung
    private static Samsung instanciaUnica;

    //Construtor PRIVADO: faz com que ninguém na Main consiga dar "new Samsung()"
    private Samsung() {
    }

    //Método público para a Main conseguir pegar a nossa fábrica
    public static Samsung getInstancia() {
        if(instanciaUnica == null) {
            instanciaUnica = new Samsung(); //Só cria se ainda não existir
        }
        return instanciaUnica;
    }
    //--- FIM DO SINGLETON ---


    //--- AQUI COMEÇA O PADRÃO FÁBRICA ---
    //Esse é o método do contrato FabricanteCelular que criei para contruir celulares
    @Override
    public Celular constroiCelular(String modelo) {
        
        //.equals() para comparar Strings
        if (modelo.equals("Galaxy 8")) {
            return new Galaxy8(); //Cria e devolve um Galaxy8
        } 
        else if(modelo.equals("Galaxy 20")) {
            return new Galaxy20(); //Cria e devolve um Galaxy20
        }
        
        //Se passarem um modelo que a Samsung não faz
        return null; 
    }
}