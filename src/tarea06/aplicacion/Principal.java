package tarea06.aplicacion;

import tarea06.modelo.Cliente;
import tarea06.modelo.ExcepcionAlquilerVehiculos;
import tarea06.modelo.AlquilerVehiculos;
import tarea06.modelo.Alquiler;
import tarea06.modelo.Turismo;
import utilidades.Entrada;

/**
 * @author Francisco Jesus Latorre Garcia <franlatorregarcia@gmail.com>
 * Crea una clase llamada Principal que incluya un método main. El método main
 * deberá mostrarnos un menú con las diferentes opciones (añadir cliente, borrar
 * cliente, listar clientes, añadir turismo, borrar turismo, listar turismos,
 * abrir un alquiler, cerrar un alquiler, listar alquileres y salir) y actuar en
 * consecuencia. El menú se repetirá mientras no elijamos la opción salir. En
 * todo caso se debe validar que todas las entradas al programa son correctas.
 * Haz un commit.
 */
public class Principal {

    public static void main(String[] args) {
        AlquilerVehiculos miAlquiler = new AlquilerVehiculos();
        Cliente cliente1 = new Cliente("Antonio", "11111111A", "Calle bistec", "Almería", "04001");
        Cliente cliente2 = new Cliente("Juanma", "22222222B", "C/Leopardo", "Almería", "04002");
        miAlquiler.addCliente(cliente1);
        miAlquiler.addCliente(cliente2);
        Turismo turismo1 = new Turismo("1111BBB", "Seat", "Ibiza", 1900);
        Turismo turismo2 = new Turismo("2222BBB", "Opel", "Corsa", 1600);
        miAlquiler.addTurismo(turismo1);
        miAlquiler.addTurismo(turismo2);
        miAlquiler.openAlquiler(cliente1, turismo1);
        miAlquiler.openAlquiler(cliente2, turismo2);
        miAlquiler.closeAlquiler(cliente1, turismo1);
        miAlquiler.openAlquiler(cliente1, turismo1);
        for (Cliente cliente : miAlquiler.getClientes()) {
            if (cliente != null) {
                System.out.println(cliente);
            }
        }
        System.out.println("--------------");
        for (Turismo turismo : miAlquiler.getTurismos()) {
            if (turismo != null) {
                System.out.println(turismo);
            }
        }
        System.out.println("--------------");
        for (Alquiler alquiler : miAlquiler.getAlquileres()) {
            if (alquiler != null) {
                System.out.println(alquiler);
            }
        }

        int opcion;
        do {
            System.out.println("Alquiler de Vehículos");
            System.out.println("---------------");
            System.out.println("1.- Añadir cliente");
            System.out.println("2.- Borrar cliente");
            System.out.println("3.- Listar clientes");
            System.out.println("4.- Añadir turismo");
            System.out.println("5.- Borrar turismo");
            System.out.println("6.- Listar turismos");
            System.out.println("7.- Abrir Alquiler");
            System.out.println("8.- Cerrar Alquiler");
            System.out.println("9.- Listar Alquileres");
            System.out.println("0.- Salir");

            do {
                System.out.print("\nElige una opción (0-9): ");
                opcion = Entrada.entero();
            } while (opcion < 0 || opcion > 9);
            switch (opcion) {
                case 1:
                    Cliente addCliente = null;
                    do {
                        System.out.println("\nAñadir cliente");
                        System.out.println("--------------");
                        System.out.print("Nombre: ");
                        String nombre = Entrada.cadena();
                        System.out.print("DNI: ");
                        String dni = Entrada.cadena();
                        System.out.print("Dirección: ");
                        String direccion = Entrada.cadena();
                        System.out.print("Localidad: ");
                        String localidad = Entrada.cadena();
                        System.out.print("Código postal: ");
                        String codigoPostal = Entrada.cadena();
                        try {
                            addCliente = new Cliente(nombre, dni, direccion, localidad, codigoPostal);
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.printf("ERROR: %s%n%n", e.getMessage());
                            System.out.println("Vuelve a introducir los datos de forma correcta");
                        }
                    } while (addCliente == null);
                    try {
                        miAlquiler.addCliente(addCliente);
                    } catch (ExcepcionAlquilerVehiculos e) {
                        System.out.printf("ERROR: %s%n%n", e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("\nBorrar cliente");
                    System.out.println("--------------");
                    System.out.print("\nIntroduce el DNI del cliente a borrar: ");
                    String dniBorrar = Entrada.cadena();
                    try {
                        miAlquiler.delCliente(dniBorrar);
                        System.out.println("Cliente borrado satisfactoriamente\n");
                    } catch (Exception e) {
                        System.out.printf("ERROR: %s%n%n", e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("\nListado de clientes");
                    System.out.println("-------------------");
                    for (Cliente cliente : miAlquiler.getClientes()) {
                        if (cliente != null) {
                            System.out.println(cliente);
                        }
                    }
                    System.out.println("");
                    break;
                case 4:
                    Turismo nuevoTurismo = null;
                    System.out.println("\nAñadir turismo");
                    System.out.println("---------------");
                    System.out.print("Matrícula: ");
                    String matricula = Entrada.cadena();
                    System.out.print("Marca: ");
                    String marca = Entrada.cadena();
                    System.out.print("Modelo: ");
                    String modelo = Entrada.cadena();
                    System.out.print("Cilindrada: ");
                    int cilindrada = Entrada.entero();
                    try {
                        nuevoTurismo = new Turismo(matricula, marca, modelo, cilindrada);
                        miAlquiler.addTurismo(nuevoTurismo);
                    } catch (ExcepcionAlquilerVehiculos e) {
                        System.out.printf("ERROR: %s%n%n", e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("\nBorrar turismo");
                    System.out.println("---------------");
                    System.out.print("\nIntroduce la matrícula del turismo a borrar: ");
                    String matriculaBorrar = Entrada.cadena();
                    try {
                        miAlquiler.delTurismo(matriculaBorrar);
                        System.out.println("Turismo borrado satisfactoriamente\n");
                    } catch (ExcepcionAlquilerVehiculos e) {
                        System.out.printf("ERROR: %s%n%n", e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("\nListado de turismos");
                    System.out.println("--------------------");
                    for (Turismo vehiculo : miAlquiler.getTurismos()) {
                        if (vehiculo != null) {
                            System.out.println(vehiculo);
                        }
                    }
                    System.out.println("");
                    break;
                case 7:
                    System.out.println("\nAbrir Alquiler");
                    System.out.println("-------------");
                    System.out.print("\nIntroduce el DNI del cliente: ");
                    String dniBuscar = Entrada.cadena();
                    Cliente clienteBuscado = miAlquiler.getCliente(dniBuscar);
                    System.out.print("\nIntroduce la matrícula del Turismo: ");
                    String matriculaBuscar = Entrada.cadena();
                    Turismo turismoBuscado = miAlquiler.getTurismo(matriculaBuscar);
                    if (turismoBuscado == null | clienteBuscado == null) {
                        System.out.println("ERROR: No existe un cliente con dicho DNI o un turismo con dicha matrícula\n");
                    } else {
                        try {
                            miAlquiler.openAlquiler(clienteBuscado, turismoBuscado);
                            System.out.println("Alquiler abierto satisfactoriamente\n");
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.printf("ERROR: %s%n%n", e.getMessage());
                        }
                    }
                    break;
                case 8:
                    System.out.println("\nCerrar Alquiler");
                    System.out.println("--------------");
                    System.out.print("\nIntroduce el DNI del cliente: ");
                    dniBuscar = Entrada.cadena();
                    clienteBuscado = miAlquiler.getCliente(dniBuscar);
                    System.out.print("\nIntroduce la matrícula del turismo: ");
                    matriculaBuscar = Entrada.cadena();
                    turismoBuscado = miAlquiler.getTurismo(matriculaBuscar);
                    if (turismoBuscado == null | clienteBuscado == null) {
                        System.out.println("ERROR: No existe un cliente con dicho DNI o un turismo con dicha matrícula\n");
                    } else {
                        try {
                            miAlquiler.closeAlquiler(clienteBuscado, turismoBuscado);
                            System.out.println("Alquiler cerrado satisfactoriamente");
                        } catch (ExcepcionAlquilerVehiculos e) {
                            System.out.printf("ERROR: %s%n%n", e.getMessage());
                        }
                    }
                    break;
                case 9:
                    System.out.println("\nListado de Alquileres");
                    System.out.println("---------------------");
                    for (Alquiler alquiler : miAlquiler.getAlquileres()) {
                        if (alquiler != null) {
                            System.out.println(alquiler);
                        }
                    }
                    System.out.println("");
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

}
