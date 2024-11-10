import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Habitacion> habitaciones = new ArrayList<>();

    public static void main(String[] args) {
        inicializarHabitaciones();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    mostrarHabitaciones();
                    break;

                case 2:
                    realizarReserva(scanner);
                    break;

                case 3:
                    liberarHabitacion(scanner);
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void inicializarHabitaciones() {
        habitaciones.add(new Habitacion("Individual", 50.0));
        habitaciones.add(new Habitacion("Doble", 75.0));
        habitaciones.add(new Habitacion("Suite", 150.0));
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Sistema de Reservas de Habitaciones ---");
        System.out.println("1. Mostrar detalles de las habitaciones");
        System.out.println("2. Realizar una reserva");
        System.out.println("3. Liberar una habitación");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarHabitaciones() {
        System.out.println("\n--- Detalles de las Habitaciones ---");
        for (int i = 0; i < habitaciones.size(); i++) {
            System.out.print("Habitación " + (i + 1) + ": ");
            habitaciones.get(i).mostrarDetalles();
            System.out.println();
        }
    }

    private static void realizarReserva(Scanner scanner) {
        System.out.print("Ingrese el número de habitación (1: Individual, 2: Doble, 3: Suite): ");
        int numeroHabitacion = scanner.nextInt() - 1; // Ajustar para índice 0
        if (numeroHabitacion < 0 || numeroHabitacion >= habitaciones.size()) {
            System.out.println("Número de habitación inválido.");
            return;
        }

        Habitacion habitacionReservar = habitaciones.get(numeroHabitacion);
        System.out.print("Ingrese el número de noches a reservar: ");
        int noches = scanner.nextInt();

        try {
            habitacionReservar.reservar(noches);
            double costoTotal = habitacionReservar.getPrecioPorNoche;
            costoTotal = habitacionReservar.getPrecioPorNoche() * noches;
            System.out.println("Reserva exitosa para " + noches + " noches.");
            System.out.println("Costo total de la reserva: " + costoTotal);
        } catch (Habitacion.HabitacionNoDisponibleException | Habitacion.NumeroDeNochesInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void liberarHabitacion(Scanner scanner) {
        System.out.print("Ingrese el número de habitación para liberar (1: Individual, 2: Doble, 3: Suite): ");
        int numeroHabitacion = scanner.nextInt() - 1; // Ajustar para índice 0
        if (numeroHabitacion < 0 || numeroHabitacion >= habitaciones.size()) {
            System.out.println("Número de habitación inválido.");
            return;
        }

        Habitacion habitacionLiberar = habitaciones.get(numeroHabitacion);
        if (habitacionLiberar.isDisponible()) {
            System.out.println("La habitación ya está disponible.");
        } else {
            habitacionLiberar.liberar();
            System.out.println("La habitación ha sido liberada y está disponible nuevamente.");
        }
    }
}