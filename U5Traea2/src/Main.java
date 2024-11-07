//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese el nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese el precio del producto: ");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.print("Ingrese la cantidad disponible: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            Producto producto = new Producto(nombre, precio, cantidad);
            producto.mostrarDetalles();

        } catch (ProductoInvalidoException | PrecioInvalidoException | CantidadInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada no válida. Asegúrese de ingresar un número para el precio y la cantidad.");
        } finally {
            scanner.close();
        }
    }
}