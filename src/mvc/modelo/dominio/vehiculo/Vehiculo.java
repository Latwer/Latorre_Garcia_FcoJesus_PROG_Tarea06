package mvc.modelo.dominio.vehiculo;

import java.util.regex.*;
import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Vehiculo {

    private String matricula, marca, modelo;
    private int cilindrada;
    private boolean disponible;

    public Vehiculo(Vehiculo vehiculo) {
        matricula = vehiculo.getMatricula();
        marca = vehiculo.getMarca();
        modelo = vehiculo.getModelo();
        cilindrada = vehiculo.getCilindrada();
        disponible = vehiculo.getDisponible();
    }

    public Vehiculo(String matricula, String marca, String modelo, int cilindrada) {
        setMatricula(matricula);
        setMarca(marca);
        setModelo(modelo);
        setCilindrada(cilindrada);
    }

    private void setMatricula(String matricula) {
        if (compruebaMatricula(matricula)) {
            this.matricula = matricula;
        } else {
            throw new ExcepcionAlquilerVehiculos("Matrícula no válida");
        }
    }

    private boolean compruebaMatricula(String matricula) {
        Pattern patron = Pattern.compile("\\d{4}[B-DF-HJ-ÑP-TV-Z]{3}");
        Matcher emparejador = patron.matcher(matricula);
        return emparejador.matches();
    }

    private void setMarca(String marca) {
        if (marca != null && !marca.equals("")) {
            this.marca = marca;
        } else {
            throw new ExcepcionAlquilerVehiculos("Marca no válida");
        }
    }

    private void setModelo(String modelo) {
        if (modelo != null && !modelo.equals("")) {
            this.modelo = modelo;
        } else {
            throw new ExcepcionAlquilerVehiculos("Modelo no válido");
        }
    }

    private void setCilindrada(int cilindrada) {
        if (cilindrada > 0) {
            this.cilindrada = cilindrada;
        } else {
            throw new ExcepcionAlquilerVehiculos("Cilindrada no válida");
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return String.format("Matrícula: %s, Marca: %s, Modelo: %s, Cilindrada: %d%n",
                matricula, marca, modelo, cilindrada);
    }
}
