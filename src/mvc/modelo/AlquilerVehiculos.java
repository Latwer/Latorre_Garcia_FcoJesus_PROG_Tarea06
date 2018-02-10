package mvc.modelo;

import mvc.modelo.dominio.*;
import mvc.modelo.dao.*;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class AlquilerVehiculos {

    private Clientes clientes;
    private Turismos turismos;
    private Alquileres alquileres;

    public AlquilerVehiculos() {
        clientes = new Clientes();
        turismos = new Turismos();
        alquileres = new Alquileres();
    }

    public Turismo[] getTurismos() {
        return turismos.getTurismos();
    }

    public Cliente[] getClientes() {
        return clientes.getClientes();
    }

    public Alquiler[] getAlquileres() {
        return alquileres.getAlquileres();
    }

    public void addTurismo(Turismo turismo) {
        //comprobarDisponibilidadTurismo(turismo);
        turismos.addTurismo(turismo);
    }

    public void delTurismo(String matricula) {
        turismos.delTurismo(matricula);
    }

    public Turismo getTurismo(String matricula) {
        return turismos.getTurismo(matricula);
    }

    public void addCliente(Cliente cliente) {
        clientes.addCliente(cliente);
    }

    public void delCliente(String dni) {
        clientes.delCliente(dni);
    }

    public Cliente getCliente(String dni) {
        return clientes.getCliente(dni);
    }

    public void openAlquiler(Cliente cliente, Turismo turismo) {
        //comprobarDisponibilidadTurismo(cliente, turismo);
        alquileres.openAlquiler(cliente, turismo);
    }

    public void closeAlquiler(Cliente cliente, Turismo turismo) {
        comprobarExistenciaClienteTurismo(cliente, turismo);
        alquileres.closeAlquiler(cliente, turismo);
    }

    /*private void comprobarDisponibilidadTurismo(Cliente cliente, Turismo turismo) {
        if (clientes.buscarCliente(turismo.getPropietario().getDni()) == null) {
            throw new ExcepcionAlquilerVehiculos("El propietario del vehículo no existe");
        }
    }*/
    private void comprobarExistenciaClienteTurismo(Cliente cliente, Turismo turismo) {
        if (turismos.getTurismo(turismo.getMatricula()) == null && clientes.getCliente(cliente.getDni()) == null) {
            throw new ExcepcionAlquilerVehiculos("El cliente o turismo no existe");
        }
    }

    public void anadirDatosPrueba() {
        Cliente cliente1 = new Cliente("Juanma", "11111111A", new DireccionPostal("calle esmeralda", "Almería", "04001"));
        Cliente cliente2 = new Cliente("Sergio", "22222222B", new DireccionPostal("calle granada", "Almería", "04002"));
        addCliente(cliente1);
        addCliente(cliente2);
        Turismo turismo1 = new Turismo("1111BBB", "Nissan", "Skyline", 1900);
        Turismo turismo2 = new Turismo("2222BBB", "Opel", "Corsa", 1600);
        addTurismo(turismo1);
        addTurismo(turismo2);
        openAlquiler(cliente1, turismo1);
        openAlquiler(cliente2, turismo2);
        closeAlquiler(cliente1, turismo1);
        closeAlquiler(cliente2, turismo2);
    }
}
