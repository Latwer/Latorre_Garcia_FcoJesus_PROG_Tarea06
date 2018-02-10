package mvc.modelo.dao;

import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.Turismo;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Alquileres {

    private Alquiler[] alquileres;
    private final int MAX_ALQUILERES = 25;

    public Alquileres() {
        alquileres = new Alquiler[MAX_ALQUILERES];
    }

    public Alquiler[] getAlquileres() {
        return alquileres.clone();
    }

    public void openAlquiler(Cliente cliente, Turismo turismo) {
        int posicion = 0;
        boolean posicionEncontrada = false;
        while (posicion < alquileres.length && !posicionEncontrada) {
            if (alquileres[posicion] == null) {
                posicionEncontrada = true;
            } else if (alquileres[posicion].getTurismo().getMatricula().equals(turismo.getMatricula())
                    && !alquileres[posicion].getTurismo().getDisponible()) {
                throw new ExcepcionAlquilerVehiculos("Ya existe un Alquiler abierto para este turismo");
            } else {
                posicion++;
            }
        }
        if (posicionEncontrada) {
            alquileres[posicion] = new Alquiler(cliente, turismo);
        } else {
            throw new ExcepcionAlquilerVehiculos("El array de Alquileres está lleno.");
        }
    }

    public void closeAlquiler(Cliente cliente, Turismo turismo) {
        int posicion = 0;
        boolean encontrado = false;
        while (posicion < alquileres.length && !encontrado) {
            if (alquileres[posicion] != null
                    && alquileres[posicion].getTurismo().getMatricula().equals(turismo.getMatricula())
                    && alquileres[posicion].getCliente().getDni().equals(cliente.getDni())
                    && !alquileres[posicion].getTurismo().getDisponible()) {
                encontrado = true;
            } else {
                posicion++;
            }
        }
        if (encontrado) {
            alquileres[posicion].close();
        } else {
            throw new ExcepcionAlquilerVehiculos("No hay ningún alquiler abierto para ese turismo");
        }
    }
}
