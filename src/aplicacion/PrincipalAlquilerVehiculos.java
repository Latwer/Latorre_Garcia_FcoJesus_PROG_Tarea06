package aplicacion;

import mvc.controlador.ControladorAlquilerVehiculos;
import mvc.modelo.AlquilerVehiculos;
import mvc.vista.IUTextual;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class PrincipalAlquilerVehiculos {

    public static void main(String[] args) {
        AlquilerVehiculos modelo = new AlquilerVehiculos();
        IUTextual vista = new IUTextual();
        ControladorAlquilerVehiculos controlador = new ControladorAlquilerVehiculos(vista, modelo);

        controlador.comenzar();
    }
}
