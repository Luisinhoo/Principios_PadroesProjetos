public interface IVehicleMaker {

    //Esse método obriga as fábricas a terem o sistema de construção por texto.
    public IVehicle makeVehicle(String modelo);
}