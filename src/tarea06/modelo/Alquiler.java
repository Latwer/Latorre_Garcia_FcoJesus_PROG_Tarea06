package tarea06.modelo;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public class Alquiler {

    private Turismo turismo;
    private Cliente cliente;
    private Date fecha;
    private int dias;
    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    private final int MS_DIA = 1000 * 60 * 60 * 24;
    private final double PRECIO_DIA = 30.0;

    public Alquiler(Cliente cliente, Turismo turismo) {
        this.cliente = cliente;
        this.turismo = turismo;
        fecha = new Date();
        dias = 0;
        turismo.setDisponible(false);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Turismo getTurismo() {
        return turismo;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getDias() {
        return dias;
    }

    public void close() {
        Date ahora = new Date();
        dias = difDias(ahora, fecha);
        turismo.setDisponible(true);
    }

    private int difDias(Date fechaFin, Date fechaInicio) {
        long milisegundos = fechaFin.getTime() - fechaInicio.getTime();
        long dias = milisegundos / MS_DIA;
        return (int) dias + 1;
    }

    public double getPrecio() {
        return PRECIO_DIA * dias + turismo.getCilindrada() / 100;
    }

    @Override
    public String toString() {
        return String.format("Fecha entrada: %s, Días: %d  Precio: %.2f%n\tCliente: %s%n\tTurismo: %s",
                FORMATO_FECHA.format(fecha), dias, getPrecio(), cliente, turismo);
    }
}
