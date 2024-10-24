package dulceria;

import java.util.ArrayList;
import java.util.Scanner;

public class Dulceria {

    public ArrayList<Producto> listaProductos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private void inicializarProductos() {
        listaProductos.add(new Producto(20,"Palomitas", 90.00));
        listaProductos.add(new Producto(10,"Refresco", 65.00));
        listaProductos.add(new Producto(30,"Nachos", 72.00));
        listaProductos.add(new Producto(12,"Nachos Chicos", 40.00));
        listaProductos.add(new Producto(33,"Paleta magnum", 50.00));
    }
    public void mostrarProductos() {
        for (Producto p : listaProductos) {
            System.out.println(p.getIdProducto() + ". " + p.getNombre() + " - $" + p.getPrecio());
        }
    }

    public void comprarProductos() {
        inicializarProductos();
        mostrarProductos();
        double total = 0.0;
        System.out.println("Ingrese el ID del producto que desea comprar (0 para salir):");
        while (true) {
            int idProducto = scanner.nextInt();
            if (idProducto == 0) {
                break;
            }
            Producto productoSeleccionado = null;
            for (Producto p : listaProductos) {
                if (p.getIdProducto() == idProducto) {
                    productoSeleccionado = p;
                    break;
                }
            }

            if (productoSeleccionado != null) {
                System.out.println("¿CANTIDAD DE:  " + productoSeleccionado.getNombre() + "?");
                int cantidad = scanner.nextInt();
                total += productoSeleccionado.getPrecio() * cantidad;
                System.out.println("Agregado: " + cantidad + " x " + productoSeleccionado.getNombre());
            } else {
                System.out.println("Producto no encontrado.");
            }
        }
        System.out.printf("Total de la compra: $%.2f\n", total);
    }
}
