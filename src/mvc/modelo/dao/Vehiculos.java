package mvc.modelo.dao;

import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.vehiculo.Vehiculo;

/**
 *
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Vehiculos {

    private Vehiculo[] Vehiculos;

    private final int MAX_TURISMOS = 25;

    public Vehiculos() {
        Vehiculos = new Vehiculo[MAX_TURISMOS];
    }

    public Vehiculo[] getVehiculos() {
        return Vehiculos.clone();
    }

    public void addVehiculo(TipoVehiculo tipoVehiculo) {
        int indice = buscarPrimerIndiceLibreComprobandoExistencia(vehiculo);
        if (indiceNoSuperaTamano(indice)) {
            Vehiculos[indice] = new Vehiculo(vehiculo);
        } else {
            throw new ExcepcionAlquilerVehiculos("El array de vehiculos está lleno.");
        }
    }

    private int buscarPrimerIndiceLibreComprobandoExistencia(Vehiculo vehiculo) {
        int indice = 0;
        boolean vehiculoEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado) {
            if (Vehiculos[indice] == null) {
                vehiculoEncontrado = true;
            } else if (Vehiculos[indice].getMatricula().equals(vehiculo.getMatricula())) {
                throw new ExcepcionAlquilerVehiculos("Ya existe un vehiculo con esa matrícula");
            } else {
                indice++;
            }
        }
        return indice;
    }

    private boolean indiceNoSuperaTamano(int indice) {
        return indice < Vehiculos.length;
    }

    public void delVehiculo(String matricula) {
        int indice = buscarIndiceVehiculo(matricula);
        if (indiceNoSuperaTamano(indice)) {
            desplazarUnaPosicionHaciaIzquierda(indice);
        } else {
            throw new ExcepcionAlquilerVehiculos("El vehiculo a borrar no existe");
        }
    }

    private int buscarIndiceVehiculo(String matricula) {
        int indice = 0;
        boolean vehiculoEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !vehiculoEncontrado) {
            if (Vehiculos[indice] != null && Vehiculos[indice].getMatricula().equals(matricula)) {
                vehiculoEncontrado = true;
            } else {
                indice++;
            }
        }
        return indice;
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        for (int i = indice; i < Vehiculos.length - 1 && Vehiculos[i] != null; i++) {
            Vehiculos[i] = Vehiculos[i + 1];
        }
    }

    public Vehiculo getVehiculo(String matricula) {
        int indice = buscarIndiceVehiculo(matricula);
        if (indiceNoSuperaTamano(indice)) {
            return new Vehiculo(Vehiculos[indice]);
        } else {
            return null;
        }
    }
}
