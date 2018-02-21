package mvc.vista;

import mvc.controlador.ControladorAlquilerVehiculos;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public interface IVistaAlquilerVehiculos {

    void abrirAlquiler();

    void anadirCliente();

    void anadirVehiculo();

    void borrarCliente();

    void borrarVehiculo();

    void buscarCliente();

    void buscarVehiculo();

    void cerrarAlquiler();

    void comenzar();

    void listarAlquileres();

    void listarClientes();

    void listarVehiculos();

    void salir();

    void setControlador(ControladorAlquilerVehiculos controlador);
    
}
