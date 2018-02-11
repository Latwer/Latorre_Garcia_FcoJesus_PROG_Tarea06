package mvc.controlador;

import mvc.modelo.AlquilerVehiculos;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Turismo;
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

    public void addTurismo(Turismo turismo) {
        modelo.addTurismo(turismo);
    }

    public void delTurismo(String matricula) {
        modelo.delTurismo(matricula);
    }

    public Turismo getTurismo(String matricula) {
        return modelo.getTurismo(matricula);
    }

    public Turismo[] getTurismos() {
        return modelo.getTurismos();
    }

    public void openAlquiler(Cliente cliente, Turismo turismo) {
        modelo.openAlquiler(cliente, turismo);
    }

    public void cerrarTrabajo(Cliente cliente, Turismo turismo) {
        modelo.closeAlquiler(cliente, turismo);
    }

    public Alquiler[] getAlquileres() {
        return modelo.getAlquileres();
    }

    public void anadirDatosPrueba() {
        modelo.anadirDatosPrueba();
    }
}
