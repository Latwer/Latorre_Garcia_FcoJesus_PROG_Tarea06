package mvc.controlador;

import mvc.modelo.AlquilerVehiculos;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.vehiculo.Vehiculo;
import mvc.vista.IUTextual;

/**
 *
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class ControladorAlquilerVehiculos {

    private AlquilerVehiculos modelo;
    private IUTextual vista;

    public ControladorAlquilerVehiculos(IUTextual vista, AlquilerVehiculos modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.setControlador(this);
    }

    public void comenzar() {
        modelo.anadirDatosPrueba();
        vista.comenzar();
    }

    public void addCliente(Cliente cliente) {
        modelo.addCliente(cliente);
    }

    public void delCliente(String dni) {
        modelo.delCliente(dni);
    }

    public Cliente getCliente(String dni) {
        return modelo.getCliente(dni);
    }

    public Cliente[] getClientes() {
        return modelo.getClientes();
    }

    public void addVehiculo(Vehiculo vehiculo) {
        modelo.addVehiculo(vehiculo);
    }

    public void delVehiculo(String matricula) {
        modelo.delVehiculo(matricula);
    }

    public Vehiculo getVehiculo(String matricula) {
        return modelo.getVehiculo(matricula);
    }

    public Vehiculo[] getVehiculos() {
        return modelo.getVehiculos();
    }

    public void openAlquiler(Cliente cliente, Vehiculo vehiculo) {
        modelo.openAlquiler(cliente, vehiculo);
    }

    public void cerrarTrabajo(Cliente cliente, Vehiculo vehiculo) {
        modelo.closeAlquiler(cliente, vehiculo);
    }

    public Alquiler[] getAlquileres() {
        return modelo.getAlquileres();
    }

    public void anadirDatosPrueba() {
        modelo.anadirDatosPrueba();
    }
}
