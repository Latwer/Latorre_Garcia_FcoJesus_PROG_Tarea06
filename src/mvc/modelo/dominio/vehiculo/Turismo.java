package mvc.modelo.dominio.vehiculo;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Turismo extends Vehiculo {

    public Turismo(Vehiculo vehiculo) {
        super(vehiculo);
    }

    /*public Turismo (Turismo turismo){
        
    }*/

    @Override
    public TipoVehiculo getTipoVehiculo() {
        return TipoVehiculo.TURISMO;
    }

    @Override
    public double getPrecioEspecifico() {
        return getPrecioEspecifico() + FACTOR_CILINDRADA / 50;
    }

}
