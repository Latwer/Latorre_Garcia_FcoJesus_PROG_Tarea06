package mvc.modelo.dao;

import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.vehiculo.Vehiculo;

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

    /*public void openAlquiler(Cliente cliente, Vehiculo vehiculo) throws ExcepcionAlquilerVehiculos {
        int indice = 0;
        boolean alquilerEncontrado = false;
        if (!vehiculo.getDisponible()) {
            throw new ExcepcionAlquilerVehiculos("El vehiculo que quiere alquilar no está disponible");
        }
        while (indice < alquileres.length && !alquilerEncontrado) {
            if (alquileres[indice] == null) {
                alquilerEncontrado = true;
            } else {
                indice++;
            }
        }
        if (indice < alquileres.length) {
            alquileres[indice] = new Alquiler(cliente, vehiculo);
        } else {
            throw new ExcepcionAlquilerVehiculos("El array de alquileres está lleno.");
        }
    }*/
    public void openAlquiler(Cliente cliente, Vehiculo vehiculo) {
        int posicion = 0;
        boolean posicionEncontrada = false;
        while (posicion < alquileres.length && !posicionEncontrada) {
            if (alquileres[posicion] == null) {
                posicionEncontrada = true;
            } else if (alquileres[posicion].getVehiculo().getMatricula().equals(vehiculo.getMatricula())
                    && !alquileres[posicion].getVehiculo().getDisponible()) {
                throw new ExcepcionAlquilerVehiculos("Ya existe un Alquiler abierto para este turismo");
            } else {
                posicion++;
            }
        }
        if (posicionEncontrada) {
            alquileres[posicion] = new Alquiler(cliente, vehiculo);
        } else {
            throw new ExcepcionAlquilerVehiculos("El array de Alquileres está lleno.");
        }
    }

    public void closeAlquiler(Cliente cliente, Vehiculo vehiculo) {
        int posicion = 0;
        boolean encontrado = false;
        while (posicion < alquileres.length && !encontrado) {
            if (alquileres[posicion] != null
                    && alquileres[posicion].getVehiculo().getMatricula().equals(vehiculo.getMatricula())
                    && alquileres[posicion].getCliente().getDni().equals(cliente.getDni())
                    && !alquileres[posicion].getVehiculo().getDisponible() && alquileres[posicion].getDias()==0) {
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
