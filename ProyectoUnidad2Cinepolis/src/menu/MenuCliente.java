package menu;
import cine.Cine;
import dulceria.Producto;

import java.time.LocalDate;
import java.util.Scanner;

import boletos.Reservacion;
import salas.Sala;
import usuarios.clientes.Cliente;

public class MenuCliente {
    
    private Scanner scanner = new Scanner(System.in);
    private Cine cine = new Cine();

    public MenuCliente(Cine cine) {
        this.cine = cine;
    }

    public void MostrarMenuCliente() {
    
        int opcion = 0;
        while (opcion != 5) {
            System.out.println("Menu Cliente");
           System.out.println("1.Ver cartelera de peliculas  ");
            System.out.println("2.comprar boletos ");
            System.out.println("3.Dulceria ");
            System.out.println("4.Pagar ");
            System.out.println("5.Salir ");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

             switch (opcion) {
        case 1:
            System.out.print("Catalogo de peliculas ");
            cine.mostrarPeliculas();
            
            break;

                 case 2:

                     System.out.println("Por favor, ingresa los datos del cliente.");

                     String id = cine.generarIdCliente();
                     System.out.println("Ingresa el nombre del cliente: ");
                     String nombreCliente= scanner.nextLine();
                     System.out.println("Ingrese apellidos del cliente: ");
                     String apellidos = scanner.nextLine();
                     System.out.println("Ingrese su curp: ");
                     String curp = scanner.nextLine();
                     System.out.println("Ingrese su direccion: ");
                     String direccion = scanner.nextLine();
                     System.out.print("Fecha de nacimiento (yyyy-MM-dd): ");
                     String fechaNacimiento = scanner.nextLine();
                     LocalDate fechaNacimientoCliente = LocalDate.parse(fechaNacimiento);

                     Cliente cliente = new Cliente(id,curp,nombreCliente,apellidos,direccion,fechaNacimientoCliente);

                     System.out.println("Selecciona una sala:");
                     cine.mostrarSalas();

                     System.out.print("Ingresa el ID de la sala: ");
                     String idSala = scanner.nextLine();
                     Sala salaSeleccionada = cine.buscarSalaPorId(idSala);

                     if (salaSeleccionada == null) {
                         System.out.println("Sala no encontrada. Intenta de nuevo.");
                         break;
                     }

                     // Comprar boletos
                     cine.comprarBoletos(cliente, salaSeleccionada);
                     break;

                 case 3:
            cine.mostrarProductosDulceria();
            String opcionS = "S";
            while (opcionS.equalsIgnoreCase("S")) {
                System.out.print("Ingresa el ID del producto de dulcería que deseas comprar: ");
                String idProducto = scanner.nextLine();

                Producto productoSeleccionado = cine.buscarProductoPorId(idProducto);

                if (productoSeleccionado != null) {
                    cine.agregarProductoAdicional(productoSeleccionado);
                    System.out.println("Producto añadido correctamente: " + productoSeleccionado.getNombre());
                } else {
                    System.out.println("Producto no encontrado. Intenta de nuevo.");
                }

                // Preguntar al usuario si desea agregar otro producto
                System.out.print("¿Deseas agregar otro producto? (S/N): ");
                opcionS = scanner.nextLine();
            }

            System.out.println("Has terminado de agregar productos.");
        break;
        case 4:
        cine.realizarPago();
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
