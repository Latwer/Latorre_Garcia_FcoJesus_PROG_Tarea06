package mvc.modelo.dao;

import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 *
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Clientes {

    private Cliente[] clientes;

    private final int MAX_CLIENTES = 25;

    public Clientes() {
        clientes = new Cliente[MAX_CLIENTES];
    }

    public Cliente[] getClientes() {
        return clientes.clone();
    }

    public void addCliente(Cliente cliente) {
        int indice = buscarPrimerIndiceLibreComprobandoExistencia(cliente);
        if (indiceNoSuperaTamano(indice)) {
            clientes[indice] = new Cliente(cliente);
        } else {
            throw new ExcepcionAlquilerVehiculos("El array de clientes está lleno.");
        }
    }

    private int buscarPrimerIndiceLibreComprobandoExistencia(Cliente cliente) {
        int indice = 0;
        boolean clienteEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !clienteEncontrado) {
            if (clientes[indice] == null) {
                clienteEncontrado = true;
            } else if (clientes[indice].getDni().equals(cliente.getDni())) {
                throw new ExcepcionAlquilerVehiculos("Ya existe un cliente con ese DNI");
            } else {
                indice++;
            }
        }
        return indice;
    }

    private boolean indiceNoSuperaTamano(int indice) {
        return indice < clientes.length;
    }

    public void delCliente(String dni) {
        int indice = buscarIndiceCliente(dni);
        if (indiceNoSuperaTamano(indice)) {
            desplazarUnaPosicionHaciaIzquierda(indice);
        } else {
            throw new ExcepcionAlquilerVehiculos("El cliente a borrar no existe");
        }
    }

    private int buscarIndiceCliente(String dni) {
        int indice = 0;
        boolean clienteEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !clienteEncontrado) {
            if (clientes[indice] != null && clientes[indice].getDni().equals(dni)) {
                clienteEncontrado = true;
            } else {
                indice++;
            }
        }
        return indice;
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        for (int i = indice; i < clientes.length - 1 && clientes[i] != null; i++) {
            clientes[i] = clientes[i + 1];
        }
    }

    public Cliente getCliente(String dni) {
        int posicion = buscarIndiceCliente(dni);
        if (indiceNoSuperaTamano(posicion)) {
            return new Cliente(clientes[posicion]);
        } else {
            return null;
        }
    }
}
