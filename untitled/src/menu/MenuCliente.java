package menu;

import cine.Cine;
import dulceria.Dulceria;
import usuarios.clientes.Cliente;

import java.time.LocalDate;
import java.util.Scanner;

public class MenuCliente {
    private Scanner scanner = new Scanner(System.in);
    private Cine cine;



    // Modificación: Agregar un constructor que reciba la instancia de Cine
    public MenuCliente(Cine cine) {
        this.cine = cine; // Guardamos la instancia de Cine
    }

    public void menuCliente() {
        Dulceria dulceria = new Dulceria();
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("\nMenú Cliente:");
            System.out.println("1. Registrarse como cliente");
            System.out.println("2. Comprar boletos");
            System.out.println("3. Ver películas en cartelera");
            System.out.println("4. Comprar en dulcería");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    // Método para comprar boletos
                    break;
                case 3:
                    cine.mostrarPeliculasEnCartelera();
                    break;
                case 4:
                    dulceria.comprarProductos();
                    break;
                case 5:
                    System.out.println("Saliendo del menú cliente...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private void registrarCliente() {
        System.out.println("Registro de Cliente:");

        System.out.print("Ingrese su CURP: ");
        String curp = scanner.nextLine();

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su apellido: ");
        String apellidos = scanner.nextLine();

        System.out.print("Ingrese su dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese su fecha de nacimiento (AAAA-MM-DD): ");
        String fechaNacimientoStr = scanner.nextLine();
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);

        Cliente nuevoCliente = new Cliente(curp, nombre, apellidos, direccion, fechaNacimiento);
        cine.getListaUsuarios().add(nuevoCliente);

        System.out.println("Cliente registrado exitosamente: " + nombre + " " + apellidos);
    }
}
