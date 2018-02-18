package mvc.modelo.dominio.vehiculo;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Autobus extends Vehiculo{
    public Autobus(Vehiculo vehiculo) {
        super(vehiculo);
    }

    /*public Autobus (Autobus autobus){
        
    }*/
    @Override
    public TipoVehiculo getTipoVehiculo() {
        return TipoVehiculo.AUTOBUS;
    }

    @Override
    public double getPrecioEspecifico() {
        return getPrecioEspecifico() + FACTOR_CILINDRADA / 50 + 1 * FACTOR_NUMERO_PLAZAS;
    }
    
}
