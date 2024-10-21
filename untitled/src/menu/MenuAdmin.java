package menu;

import cine.Cine;
import salas.Sala;
import usuarios.administrador.Administrador;
import java.util.Scanner;

public class MenuAdmin {
    private Scanner scanner = new Scanner(System.in);
    private Cine cine = new Cine();


    public void menuAdmin() {

        int opcion = 0;
        while (opcion != 6) {
            System.out.println("\nMenú Administrador");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar película: ");
            System.out.println("2. Gestionar salas y asientos: ");
            System.out.println("3. Consultar reservas: ");
            System.out.println("5Asignar pelicula a sala. Salir: ");
            System.out.println("6.- Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Registrar película...");
                    cine.registrarPelicula();

                    break;
                case 2:
                    cine.asignarSalas();  // Asignar salas y asientos
                    break;
                case 3:
                    System.out.println("Funcionalidad de consultar reservas...");
                    System.out.println("Consultando reservas...");
                    cine.consultarReservas();
                    break;
                case 4:
                    System.out.println("Saliendo del menú administrador...");
                    break;

                case 5:
                    System.out.println("Asignar película a una sala...");
                    cine.asignarPeliculaASala();
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

    }

    }
