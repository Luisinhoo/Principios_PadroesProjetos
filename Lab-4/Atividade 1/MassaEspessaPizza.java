public class MassaEspessaPizza implements Pizza {
    @Override
    public String getDescricao() {
        return "Pizza de Massa Espessa";
    }

    @Override
    public double getCusto() {
        return 105.00; //Preço base da massa espessa
    }
}