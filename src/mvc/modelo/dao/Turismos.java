package mvc.modelo.dao;

import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;
import mvc.modelo.dominio.Turismo;

/**
 *
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Turismos {

    private Turismo[] turismos;

    private final int MAX_TURISMOS = 25;

    public Turismos() {
        turismos = new Turismo[MAX_TURISMOS];
    }

    public Turismo[] getTurismos() {
        return turismos.clone();
    }

    public void addTurismo(Turismo turismo) {
        int indice = buscarPrimerIndiceLibreComprobandoExistencia(turismo);
        if (indiceNoSuperaTamano(indice)) {
            turismos[indice] = new Turismo(turismo);
        } else {
            throw new ExcepcionAlquilerVehiculos("El array de turismoss está lleno.");
        }
    }

    private int buscarPrimerIndiceLibreComprobandoExistencia(Turismo turismo) {
        int indice = 0;
        boolean turismoEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !turismoEncontrado) {
            if (turismos[indice] == null) {
                turismoEncontrado = true;
            } else if (turismos[indice].getMatricula().equals(turismo.getMatricula())) {
                throw new ExcepcionAlquilerVehiculos("Ya existe un turismo con esa matrícula");
            } else {
                indice++;
            }
        }
        return indice;
    }

    private boolean indiceNoSuperaTamano(int indice) {
        return indice < turismos.length;
    }

    public void delTurismo(String matricula) {
        int indice = buscarIndiceTurismo(matricula);
        if (indiceNoSuperaTamano(indice)) {
            desplazarUnaPosicionHaciaIzquierda(indice);
        } else {
            throw new ExcepcionAlquilerVehiculos("El turismo a borrar no existe");
        }
    }

    private int buscarIndiceTurismo(String matricula) {
        int indice = 0;
        boolean turismoEncontrado = false;
        while (indiceNoSuperaTamano(indice) && !turismoEncontrado) {
            if (turismos[indice] != null && turismos[indice].getMatricula().equals(matricula)) {
                turismoEncontrado = true;
            } else {
                indice++;
            }
        }
        return indice;
    }

    private void desplazarUnaPosicionHaciaIzquierda(int indice) {
        for (int i = indice; i < turismos.length - 1 && turismos[i] != null; i++) {
            turismos[i] = turismos[i + 1];
        }
    }

    public Turismo getTurismo(String matricula) {
        int indice = buscarIndiceTurismo(matricula);
        if (indiceNoSuperaTamano(indice)) {
            return new Turismo(turismos[indice]);
        } else {
            return null;
        }
    }
}
