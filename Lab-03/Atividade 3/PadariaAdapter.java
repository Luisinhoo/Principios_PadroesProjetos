public class PadariaAdapter implements InterfacePadaria {
    private SistemaAntigoCobranca sistemaAntigo;

    public PadariaAdapter() {
        this.sistemaAntigo = new SistemaAntigoCobranca();
    }

    @Override
    public double processarCompra(int pao, int cafe, int paoQueijo, int rosca, int salgado) {
        double descontoTotal = 0.0;

        //Regra de Desconto: Se passar de 10 unidades, calcula 10% de desconto naqueles itens
        if (pao > 10)       descontoTotal += (pao * 0.50) * 0.10;
        if (cafe > 10)      descontoTotal += (cafe * 1.50) * 0.10;
        if (paoQueijo > 10) descontoTotal += (paoQueijo * 1.00) * 0.10;
        if (rosca > 10)     descontoTotal += (rosca * 2.50) * 0.10;
        if (salgado > 10)   descontoTotal += (salgado * 5.00) * 0.10;

        //ADAPTAÇÃO: Convertendo os ints modernos para as Strings exigidas pelo sistema antigo
        String pStr  = String.valueOf(pao);
        String cStr  = String.valueOf(cafe);
        String pqStr = String.valueOf(paoQueijo);
        String rStr  = String.valueOf(rosca);
        String sStr  = String.valueOf(salgado);

        //Delega o cálculo bruto para o software antigo
        double valorBruto = sistemaAntigo.emitirNotaBruta(pStr, cStr, pqStr, rStr, sStr);

        //Retorna o valor final com o desconto do Luís aplicado de verdade!
        return valorBruto - descontoTotal;
    }
}