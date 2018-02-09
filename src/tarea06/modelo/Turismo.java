package tarea06.modelo;

import java.util.regex.*;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Turismo {

    private String matricula, marca, modelo;
    private int cilindrada;
    private boolean disponible;

    public Turismo(Turismo turismo) {
        matricula = turismo.getMatricula();
        marca = turismo.getMarca();
        modelo = turismo.getModelo();
        cilindrada = turismo.getCilindrada();
        disponible=turismo.getDisponible();
    }

    public Turismo(String matricula, String marca, String modelo, int cilindrada) {
        //Matricula
        if (compruebaMatricula(matricula)) {
            this.matricula = matricula;
        } else {
            throw new ExcepcionAlquilerVehiculos("Matrícula incorrecta.");
        }
        //Marca
        this.marca = marca;
        //Modelo
        this.modelo = modelo;
        //Cilindrada
        if (cilindrada > 0) {
            this.cilindrada = cilindrada;
        } else {
            throw new ExcepcionAlquilerVehiculos("Cilindrada no válida");
        }
        
    }

    private boolean compruebaMatricula(String matricula) {
        Pattern patron = Pattern.compile("\\d{4}[B-DF-HJ-ÑP-TV-Z]{3}");
        Matcher emparejador = patron.matcher(matricula);
        return emparejador.matches();
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
