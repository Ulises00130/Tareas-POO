package menu;

import cine.Cine;
import java.util.Scanner;

public class MenuAdmin {
    private Scanner scanner = new Scanner(System.in);
    private Cine cine;

    // Modificación: Agregar un constructor que reciba la instancia de Cine
    public MenuAdmin(Cine cine) {
        this.cine = cine; // Guardamos la instancia de Cine
    }

    public void menuAdmin() {
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("\nMenú Administrador");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar película");
            System.out.println("2. Gestionar salas y asientos");
            System.out.println("3. Consultar reservas");
            System.out.println("5. Asignar película a sala");
            System.out.println("6. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Registrar película...");
                    cine.registrarPelicula();
                    break;
                case 2:
                    cine.asignarSalas();
                    break;
                case 3:
                    cine.consultarReservas();
                    break;
                case 5:
                    cine.asignarPeliculaASala();
                    break;
                case 6:
                    System.out.println("Saliendo del menú administrador...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
