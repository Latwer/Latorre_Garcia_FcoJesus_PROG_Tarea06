package mvc.modelo;

import mvc.modelo.dominio.Turismo;
import mvc.modelo.dominio.Alquiler;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class AlquilerVehiculos {

    private Cliente[] clientes;
    private Turismo[] turismos;
    private Alquiler[] alquileres;

    private final int MAX_CLIENTES = 25;
    private final int MAX_TURISMOS = 25;
    private final int MAX_ALQUILERES = 25;

    public AlquilerVehiculos() {
        clientes = new Cliente[MAX_CLIENTES];
        turismos = new Turismo[MAX_TURISMOS];
        alquileres = new Alquiler[MAX_ALQUILERES];
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public Turismo[] getTurismos() {
        return turismos;
    }

    public Alquiler[] getAlquileres() {
        return alquileres;
    }

    public Cliente getCliente(String dni) {
        int posicion = 0;
        boolean encontrado = false;
        while (posicion < clientes.length && !encontrado) {
            if (clientes[posicion] != null && clientes[posicion].getDni().equals(dni)) {
                encontrado = true;
            } else {
                posicion++;
            }
        }
        if (encontrado) {
            return clientes[posicion];
        } else {
            return null;
        }
    }

    public void addCliente(Cliente cliente) {
        int posicion = 0;
        boolean posicionEncontrada = false;
        while (posicion < clientes.length && !posicionEncontrada) {
            if (clientes[posicion] == null) {
                posicionEncontrada = true;
            } else if (clientes[posicion].getDni().equals(cliente.getDni())) {
                throw new ExcepcionAlquilerVehiculos("Ya existe un cliente con ese DNI");
            } else {
                posicion++;
            }
        }
        if (posicionEncontrada) {
            clientes[posicion] = cliente;
        } else {
            throw new ExcepcionAlquilerVehiculos("El array de clientes está lleno.");
        }
    }

    public void delCliente(String dni) {
        int posicion = 0;
        boolean encontrado = false;
        while (posicion < clientes.length && !encontrado) {
            if (clientes[posicion] != null && clientes[posicion].getDni().equals(dni)) {
                encontrado = true;
            } else {
                posicion++;
            }
        }
        if (encontrado) {
            for (int i = posicion; i < clientes.length - 1; i++) {
                clientes[i] = clientes[i + 1];
            }
            clientes[clientes.length - 1] = null;
        } else {
            throw new ExcepcionAlquilerVehiculos("El cliente a borrar no existe");
        }
    }

    public Turismo getTurismo(String matricula) {
        int posicion = 0;
        boolean encontrado = false;
        while (posicion < turismos.length && !encontrado) {
            if (turismos[posicion] != null && turismos[posicion].getMatricula().equals(matricula)) {
                encontrado = true;
            } else {
                posicion++;
            }
        }
        if (encontrado) {
            return turismos[posicion];
        } else {
            return null;
        }
    }

    public void addTurismo(Turismo turismo) {
        int posicion = 0;
        boolean posicionEncontrada = false;
        while (posicion < turismos.length && !posicionEncontrada) {
            if (turismos[posicion] == null) {
                posicionEncontrada = true;
            } else if (turismos[posicion].getMatricula().equals(turismo.getMatricula())) {
                throw new ExcepcionAlquilerVehiculos("Ya existe un turismo con esa matrícula");
            } else {
                posicion++;
            }
        }
        if (posicionEncontrada) {
            turismos[posicion] = turismo;
        } else {
            throw new ExcepcionAlquilerVehiculos("El array de turismos está lleno.");
        }
    }

    public void delTurismo(String matricula) {
        int posicion = 0;
        boolean encontrado = false;
        while (posicion < turismos.length && !encontrado) {
            if (turismos[posicion] != null && turismos[posicion].getMatricula().equals(matricula)) {
                encontrado = true;
            } else {
                posicion++;
            }
        }
        if (encontrado) {
            for (int i = posicion; i < turismos.length - 1; i++) {
                turismos[i] = turismos[i + 1];
            }
            turismos[turismos.length - 1] = null;
        } else {
            throw new ExcepcionAlquilerVehiculos("El turismo a borrar no existe");
        }
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
