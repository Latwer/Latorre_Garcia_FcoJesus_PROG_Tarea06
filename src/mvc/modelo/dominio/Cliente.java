package mvc.modelo.dominio;

import java.util.regex.*;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Cliente {

    private String nombre, dni;
    private DireccionPostal direccionPostal;
    private int identificador;
    private static int ultimoIdentificador = 0;

    public Cliente(Cliente cliente) {
        nombre = cliente.getNombre();
        dni = cliente.getDni();
        direccionPostal = cliente.getDireccionPostal();
        identificador = cliente.getIdentificador();
    }

    private void asignarNuevoIdentificador() {
        ultimoIdentificador++;
        identificador = ultimoIdentificador;
    }

    public Cliente(String nombre, String dni, DireccionPostal direccionPostal) {
        setNombre(nombre);
        setDni(dni);
        setDireccionPostal(direccionPostal);
        asignarNuevoIdentificador();
    }

    private void setNombre(String nombre) {
        if (nombre != null && !nombre.equals("")) {
            this.nombre = nombre;
        } else {
            throw new ExcepcionAlquilerVehiculos("Nombre no válido");
        }
    }

    private void setDni(String dni) {
        if (compruebaDni(dni)) {
            this.dni = dni;
        } else {
            throw new ExcepcionAlquilerVehiculos("DNI no válido");
        }
    }

    private boolean compruebaDni(String dni) {
        Pattern patron = Pattern.compile("\\d{8}[A-HJ-NP-TV-Z]");
        Matcher emparejador = patron.matcher(dni);
        return emparejador.matches();
    }

    public void setDireccionPostal(DireccionPostal direccionPostal) {
        this.direccionPostal = new DireccionPostal(direccionPostal);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public DireccionPostal getDireccionPostal() {
        return new DireccionPostal(direccionPostal);
    }

    public int getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        return String.format("Identificador: %d, Nombre: %s, DNI: %s, %s",
                identificador, nombre, dni, direccionPostal);
    }

}
