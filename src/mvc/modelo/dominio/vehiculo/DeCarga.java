package mvc.modelo.dominio.vehiculo;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class DeCarga extends Vehiculo {

    public DeCarga(Vehiculo vehiculo) {
        super(vehiculo);
    }

    /*public Turismo (Turismo turismo){
        
    }*/
    @Override
    public TipoVehiculo getTipoVehiculo() {
        return TipoVehiculo.DE_CARGA;
    }

    @Override
    public double getPrecioEspecifico() {
        return getPrecioEspecifico() + FACTOR_PMA / 20 + 1 * FACTOR_NUMERO_PLAZAS;
    }
}
