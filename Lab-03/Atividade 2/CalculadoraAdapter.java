public class CalculadoraAdapter implements CalculadoraDecimal {
    //Guarda a calculadora binária que vamos adaptar
    private CalculadoraBinaria calcBinaria;

    public CalculadoraAdapter() {
        this.calcBinaria = new CalculadoraBinaria();
    }

    @Override
    public int somar(int a, int b) {
        //Adaptação: Converte os ints recebidos para Strings Binárias
        String binA = Integer.toBinaryString(a);
        String binB = Integer.toBinaryString(b);

        //Delegação: Pede para a calculadora binária resolver
        String resultadoBinario = calcBinaria.somar(binA, binB);

        //Adaptação final: Pega a String binária de resposta e converte de volta para int
        return Integer.parseInt(resultadoBinario, 2);
    }

    @Override
    public int subtrair(int a, int b) {
        //Adaptação: Converte os ints recebidos para Strings Binárias
        String binA = Integer.toBinaryString(a);
        String binB = Integer.toBinaryString(b);
        
        //Delegação: Pede para a calculadora binária resolver
        String resultadoBinario = calcBinaria.subtrair(binA, binB);
        
        //Adaptação final: Pega a String binária de resposta e converte de volta para int
        return Integer.parseInt(resultadoBinario, 2);
    }

    @Override
    public int multiplicar(int a, int b) {
        //O enunciado diz que a binária só tem somar e subtrair. Então a multiplicação calculamos direto em decimal por aqui mesmo!
        return a * b;
    }
}