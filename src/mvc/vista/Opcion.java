package mvc.vista;

import mvc.modelo.dominio.ExcepcionAlquilerVehiculos;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 */
public enum Opcion {
    SALIR("Salir") {
        public void ejecutar() {
            vista.salir();
        }
    },
    ANADIR_CLIENTE("Añadir cliente") {
        public void ejecutar() {
            vista.anadirCliente();
        }
    },
    BORRAR_CLIENTE("Borrar cliente") {
        public void ejecutar() {
            vista.borrarCliente();
        }
    },
    BUSCAR_CLIENTE("Buscar cliente") {
        public void ejecutar() {
            vista.buscarCliente();
        }
    },
    LISTAR_CLIENTES("Listar clientes") {
        public void ejecutar() {
            vista.listarClientes();
        }
    },
    ANADIR_TURISMO("Añadir turismo") {
        public void ejecutar() {
            vista.anadirTurismo();
        }
    },
    BORRAR_TURISMO("Borrar turismo") {
        public void ejecutar() {
            vista.borrarTurismo();
        }
    },
    BUSCAR_TURISMO("Buscar turismo") {
        public void ejecutar() {
            vista.buscarTurismo();
        }
    },
    LISTAR_TURISMOS("Listar turismos") {
        public void ejecutar() {
            vista.listarTurismos();
        }
    },
    ABRIR_ALQUILER("Abrir alquiler") {
        public void ejecutar() {
            vista.abrirAlquiler();
        }
    },
    CERRAR_ALQUILER("Cerrar alquiler") {
        public void ejecutar() {
            vista.cerrarAlquiler();
        }
    },
    LISTAR_ALQUILERES("Listar alquileres") {
        public void ejecutar() {
            vista.listarAlquileres();
        }
    };
    private String mensaje;
    private static IUTextual vista;

    private Opcion(String mensaje) {
        this.mensaje = mensaje;
    }

    public abstract void ejecutar();

    public String getMensaje() {
        return mensaje;
    }

    public static void setVista(IUTextual vista) {
        Opcion.vista = vista;
    }

    public String toString() {
        return String.format("%d.- %s", ordinal(), mensaje);
    }

    public static Opcion getOpcionSegunOridnal(int ordinal) {
        if (esOrdinalValido(ordinal)) {
            return values()[ordinal];
        } else {
            throw new ExcepcionAlquilerVehiculos("Ordinal de la opción no válido");
        }
    }

    public static boolean esOrdinalValido(int ordinal) {
        return (ordinal >= 0 && ordinal <= values().length - 1) ? true : false;
    }

}
