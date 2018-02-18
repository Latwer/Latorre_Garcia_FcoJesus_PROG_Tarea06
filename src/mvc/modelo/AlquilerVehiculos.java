package mvc.modelo;

import mvc.modelo.dominio.vehiculo.Vehiculo;
import mvc.modelo.dominio.*;
import mvc.modelo.dao.*;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class AlquilerVehiculos {

    private Clientes clientes;
    private Vehiculos vehiculos;
    private Alquileres alquileres;

    public AlquilerVehiculos() {
        clientes = new Clientes();
        vehiculos = new Vehiculos();
        alquileres = new Alquileres();
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos.getVehiculos();
    }

    public Cliente[] getClientes() {
        return clientes.getClientes();
    }

    public Alquiler[] getAlquileres() {
        return alquileres.getAlquileres();
    }

    public void addVehiculo(Vehiculo vehiculo) {
        //comprobarDisponibilidadTurismo(vehiculo);
        vehiculos.addVehiculo(vehiculo);
    }

    public void delVehiculo(String matricula) {
        vehiculos.delVehiculo(matricula);
    }

    public Vehiculo getVehiculo(String matricula) {
        return vehiculos.getVehiculo(matricula);
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

    public void openAlquiler(Cliente cliente, Vehiculo vehiculo) {
        //comprobarDisponibilidadTurismo(cliente, turismo);
        alquileres.openAlquiler(cliente, vehiculo);
    }

    public void closeAlquiler(Cliente cliente, Vehiculo vehiculo) {
        comprobarExistenciaClienteTurismo(cliente, vehiculo);
        alquileres.closeAlquiler(cliente, vehiculo);
    }

    /*private void comprobarDisponibilidadTurismo(Cliente cliente, Vehiculo turismo) {
        if (clientes.buscarCliente(turismo.getPropietario().getDni()) == null) {
            throw new ExcepcionAlquilerVehiculos("El propietario del vehículo no existe");
        }
    }*/
    private void comprobarExistenciaClienteTurismo(Cliente cliente, Vehiculo vehiculo) {
        if (vehiculos.getVehiculo(vehiculo.getMatricula()) == null && clientes.getCliente(cliente.getDni()) == null) {
            throw new ExcepcionAlquilerVehiculos("El cliente o turismo no existe");
        }
    }

    public void anadirDatosPrueba() {
        Cliente cliente1 = new Cliente("Juanma", "11111111A", new DireccionPostal("calle esmeralda", "Almería", "04001"));
        Cliente cliente2 = new Cliente("Sergio", "22222222B", new DireccionPostal("calle granada", "Almería", "04002"));
        addCliente(cliente1);
        addCliente(cliente2);
        Vehiculo vehiculo1 = new Vehiculo("1111BBB", "Nissan", "Skyline", 1900);
        Vehiculo vehiculo2 = new Vehiculo("2222BBB", "Opel", "Corsa", 1600);
        addVehiculo(vehiculo1);
        addVehiculo(vehiculo2);
        openAlquiler(cliente1, vehiculo1);
        openAlquiler(cliente2, vehiculo2);
        closeAlquiler(cliente1, vehiculo1);
        closeAlquiler(cliente2, vehiculo2);
    }
}
