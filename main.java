import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Producto producto = new Producto("Iphone 16 pro", 25000, 10);

        while (true) {
            System.out.println("1. Mostrar producto");
            System.out.println("2. Aumentar stock");
            System.out.println("3. Reducir stock");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println(producto);
                    break;
                case 2:
                    System.out.print("Cantidad a aumentar: ");
                    int aumento = scanner.nextInt();
                    try {
                        producto.aumentarStock(aumento);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Cantidad a reducir: ");
                    int reduccion = scanner.nextInt();
                    try {
                        producto.reducirStock(reduccion);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
