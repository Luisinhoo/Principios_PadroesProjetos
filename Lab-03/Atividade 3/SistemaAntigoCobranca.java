public class SistemaAntigoCobranca {
    
    public double emitirNotaBruta(String qtdPao, String qtdCafe, String qtdPaoQueijo, String qtdRosca, String qtdSalgado) {
        //Transforma os textos recebidos em números inteiros para calcular
        int p = Integer.parseInt(qtdPao);
        int c = Integer.parseInt(qtdCafe);
        int pq = Integer.parseInt(qtdPaoQueijo);
        int r = Integer.parseInt(qtdRosca);
        int s = Integer.parseInt(qtdSalgado);

        //Tabela de preços fixa e sem descontos do sistema antigo
        return (p * 0.50) + (c * 1.50) + (pq * 1.00) + (r * 2.50) + (s * 5.00);
    }
}