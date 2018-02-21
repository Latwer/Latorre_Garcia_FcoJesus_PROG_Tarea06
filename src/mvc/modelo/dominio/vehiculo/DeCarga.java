package mvc.modelo.dominio.vehiculo;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class DeCarga extends Vehiculo {

    public DeCarga(String matricula, String marca, String modelo, DatosTecnicosVehiculo datosTecnicos) {
        super(matricula, marca, modelo, datosTecnicos);
    }

    public DeCarga(DeCarga deCarga) {
        super(deCarga);
    }

    @Override
    public TipoVehiculo getTipoVehiculo() {
        return TipoVehiculo.DE_CARGA;
    }

    @Override
    public double getPrecioEspecifico() {
        return FACTOR_PMA / 20 + 1 * FACTOR_NUMERO_PLAZAS;
    }
}
