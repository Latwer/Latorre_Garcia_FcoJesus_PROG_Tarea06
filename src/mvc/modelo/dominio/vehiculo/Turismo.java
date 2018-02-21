package mvc.modelo.dominio.vehiculo;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Turismo extends Vehiculo {

    public Turismo(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
        super(matricula, marca, modelo, datosTecnicos);
    }

    public Turismo(Turismo turismo) {
        super(turismo);
    }

    @Override
    public TipoVehiculo getTipoVehiculo() {
        return TipoVehiculo.TURISMO;
    }

    @Override
    public double getPrecioEspecifico() {
        return FACTOR_CILINDRADA / 50;
    }

}
