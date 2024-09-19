import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("*** BIEVENIDO ***");
            System.out.println("1. Consultorio");
            System.out.println("2. Consulta");
            System.out.println("3. Pacientes");
            System.out.println("4. Médicos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Consultorio");
                    
                    break;
                case 2:
                    System.out.println(" Consulta");
                    break;
                case 3:
                    System.out.println("Pacientes");
                    break;
                case 4:
                    System.out.println("Médicos");
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println(); 
               } while (opcion != 5);

        scanner.close();
    }
}
