package menu;
import cine.Cine;
import java.util.Scanner;

public class MenuCliente {
    
    private Scanner scanner = new Scanner(System.in);
    private Cine cine = new Cine();

    public void MostrarMenuCliente() {
    
        int opcion = 0;
        while (opcion != 2) {
            System.out.println("Menu Cliente");
           System.out.println("1.Ver cartelera de peliculas  ");
            System.out.println("2.comprar boletos ");
            System.out.println("3.Reservar ");
            System.out.println("4.Dulceria ");
            System.out.println("6.Salir ");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();



             switch (opcion) {
        case 1:
            System.out.print("Catalogo de peliculas ");
            cine.mostrarCatalogoPeliculas();
            
            break;

        case 2:
            

            break;

        case 3:

            break;

        case 4:

           
            break;
        case 5:
            System.out.println("Saliendo...");
            break;
        default:
            System.out.println("Opción no válida. Inténtalo de nuevo.");
    }
}
            


            









            
        }
}


   








   

