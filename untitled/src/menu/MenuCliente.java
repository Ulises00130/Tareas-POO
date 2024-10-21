package menu;

import catalogopeliculas.Pelicula;
import cine.Cine;
import salas.Sala;
import usuarios.clientes.Cliente;

import java.util.List;
import java.util.Scanner;

public class MenuCliente {
    private Scanner scanner = new Scanner(System.in);
    private Cine cine;
    private Cliente cliente;

    public MenuCliente(Cliente cliente, Cine cine) {
        this.cliente = cliente;
        this.cine = cine;
    }



    public void menuCliente() {
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\nMenú Cliente");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ver catálogo de películas");
            System.out.println("2. Reservar boletos");
            System.out.println("3. Comprar boletos");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    verCatalogoPeliculas();
                    break;
                case 2:
                    reservarBoletos();
                    break;
                case 3:
                    comprarBoletos();
                    break;
                case 4:
                    System.out.println("Saliendo del menú cliente...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    private void verCatalogoPeliculas() {
        System.out.println("Catálogo de películas disponibles:");

        // Obtener la lista de películas del cine
        List<Pelicula> peliculas = cine.getListaPeliculas();

        // Verificar si hay películas disponibles
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas disponibles en el catálogo.");
            return;
        }

        // Mostrar cada película en el catálogo
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.toString());
        }
    }

    private void reservarBoletos() {
        System.out.println("Reservar boletos...");

        // Paso 1: Mostrar el catálogo de películas
        verCatalogoPeliculas();

        // Paso 2: Seleccionar una película
        System.out.print("Seleccione el título de la película: ");
        String tituloPelicula = scanner.nextLine();
        Pelicula peliculaSeleccionada = cine.buscarPelicula(tituloPelicula);

        if (peliculaSeleccionada == null) {
            System.out.println("Película no encontrada.");
            return;
        }

        // Paso 3: Mostrar salas disponibles
        System.out.println("Salas disponibles para " + peliculaSeleccionada.getTitulo() + ":");
        List<Sala> salasDisponibles = cine.getSalasDisponibles(peliculaSeleccionada);
        for (Sala sala : salasDisponibles) {
            System.out.println("Sala " + sala.getNumeroSala() + " - Capacidad: " + sala.getCapacidad());
        }

        // Paso 4: Seleccionar una sala
        System.out.print("Seleccione el número de la sala: ");
        int numeroSala = scanner.nextInt();
        scanner.nextLine();
        Sala salaSeleccionada = cine.getSala(numeroSala);

        if (salaSeleccionada == null) {
            System.out.println("Sala no encontrada.");
            return;
        }

        // Mostrar el mapa de asientos
        salaSeleccionada.mostrarMapaAsientos();

        // Paso 5: Seleccionar asientos
        System.out.print("Ingrese la cantidad de asientos a reservar: ");
        int cantidadAsientos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidadAsientos; i++) {
            System.out.print("Seleccione el ID del asiento (Ejemplo: A1): ");
            String idAsiento = scanner.nextLine();

            // Reservar el asiento
            salaSeleccionada.reservarAsiento(idAsiento);
        }

        System.out.println("Reservas completadas con éxito.");
    }

    private void comprarBoletos() {
        System.out.println("Comprar boletos...");

        // Paso 1: Mostrar el catálogo de películas
        verCatalogoPeliculas();

        // Paso 2: Seleccionar una película
        System.out.print("Seleccione el título de la película: ");
        String tituloPelicula = scanner.nextLine();
        Pelicula peliculaSeleccionada = cine.buscarPelicula(tituloPelicula);

        if (peliculaSeleccionada == null) {
            System.out.println("Película no encontrada.");
            return;
        }

        // Paso 3: Mostrar salas disponibles
        System.out.println("Salas disponibles para " + peliculaSeleccionada.getTitulo() + ":");
        List<Sala> salasDisponibles = cine.getSalasDisponibles(peliculaSeleccionada);
        for (Sala sala : salasDisponibles) {
            System.out.println("Sala " + sala.getNumeroSala() + " - Capacidad: " + sala.getCapacidad());
        }

        // Paso 4: Seleccionar una sala
        System.out.print("Seleccione el número de la sala: ");
        int numeroSala = scanner.nextInt();
        scanner.nextLine();
        Sala salaSeleccionada = cine.getSala(numeroSala);

        if (salaSeleccionada == null) {
            System.out.println("Sala no encontrada.");
            return;
        }

        // Mostrar el mapa de asientos
        salaSeleccionada.mostrarMapaAsientos();

    }
}

