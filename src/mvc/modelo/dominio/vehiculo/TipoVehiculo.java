package mvc.modelo.dominio.vehiculo;

import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public enum TipoVehiculo {
    TURISMO("Vehiculo de tipo turismo") {
        public Turismo getInstancia(Vehiculo vehiculo) {
            return new Turismo(vehiculo);
        }
    },
    DE_CARGA("Vehiculo de carga") {
        public DeCarga getInstancia(Vehiculo vehiculo) {
            return new DeCarga(vehiculo);
        }
    },
    AUTOBUS("Vehiculo de tipo autobus") {
        public Autobus getInstancia(Vehiculo vehiculo) {
            return new Autobus(vehiculo);
        }
    };
    private String tipo;

    private TipoVehiculo(String tipo) {
        this.tipo = tipo;
    }

    public abstract Vehiculo getInstancia(Vehiculo vehiculo);

    public String toString() {
        return tipo;
    }

    public static TipoVehiculo getTipoVehiculoSegunOrdinal(int ordinal) {
        if (esOrdinalValido(ordinal)) {
            return values()[ordinal];
        } else {
            throw new ExcepcionAlquilerVehiculos("Ordinal del tipo de vehiculo no válido");
        }
    }

    public static boolean esOrdinalValido(int ordinal) {
        return (ordinal >= 0 && ordinal <= values().length - 1);
    }
}
