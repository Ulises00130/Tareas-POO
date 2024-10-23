package menu;

import cine.Cine;
import java.util.Scanner;
import peliculas.Pelicula;
import usuarios.clientes.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdmin {
    public ArrayList <Pelicula> listaPeliculas= new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Cine cine = new Cine();
    
    public void mostrarMenuAdmin() {
        int opcion = 0;
        while (opcion != 9) {
            System.out.println("Menu Administrador");
            System.out.println("1. Agregar películas");
            System.out.println("2. Registrar clientes");
            System.out.println("3. Eliminar película");
            System.out.println("4. Agregar producto de dulcería");
            System.out.println("5. Eliminar producto de la dulcería");
            System.out.println("6.- Lista de usuarios registrados: ");
            System.out.println("7.- Registrar un horario:");
            System.out.println("8.- Lista de peliculas registradas: ");
            System.out.println("9. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcion) {
                case 1:
                System.out.println("Seleccionaste la opcion para registrar una pelicula. ");
                String idPelicula = cine.generarIdPelicula();
                System.out.println("Ingresa el titulo de la pelicula: ");
                String titulo = scanner.nextLine();
                System.out.println("Ingresa el genero de la pelicula: ");
                String genero = scanner.nextLine();
                System.out.println("Ingresa la clasificacion: ");
                String clasificacion = scanner.nextLine();
                System.out.println("Ingresa la duracion en minutos: ");
                int duracion = scanner.nextInt();
                System.out.println("Ingresa la sinopsis :"); 
                String sinopsis = scanner.nextLine();
                scanner.nextLine();
                Pelicula pelicula = new Pelicula(idPelicula, titulo, genero, clasificacion, duracion, sinopsis);
                cine.aniadirPelicula(pelicula);
                System.out.println("Pelicula agregada con el id: "+pelicula.getId()+" correctamente." );

                    break;
                case 2:
                System.out.println("\nSeleccionaste la opción para Registrar cliente");
                String id = cine.generarIdCliente();
                System.out.println("Ingresa el nombre del cliente: ");
                String nombrecliente= scanner.nextLine();
                System.out.println("Ingrese apellidos del cliente: ");
                String apellidos = scanner.nextLine();
                System.out.println("Ingresa el anio de nacimiento del cliente:");
                int dia = scanner.nextInt();
                System.out.println("Ingresa el mes: ");
                int mes = scanner.nextInt();
                System.out.println("Ingresa el dia: ");
                int anio = scanner.nextInt();
                LocalDate fechaDeNacimiento =LocalDate.of(dia, mes, anio);
                System.out.println("Ingrese su curp: ");
                String curp = scanner.nextLine();
                System.out.println("Ingrese su direccion: ");
                String direccion = scanner.nextLine();
                Cliente cliente = new Cliente(id,curp,nombrecliente,apellidos,direccion,fechaDeNacimiento);
                cine.aniadirCliente(cliente);
                System.out.println("Cliente registrado correctamente.");
                    break;
                case 3:
                    System.out.println("Eliminar película...");
                    System.out.println("Ingresa el id de la pelicula a eliminar: ");
                    String idPeliculaEliminar = scanner.nextLine();
                    cine.eliminarPelicula(idPeliculaEliminar);
                    break;
                case 4:
                    System.out.println("Agregar producto de dulcería...");

                    break;
                case 5:
                    System.out.println("Eliminar producto de la dulcería...");
                    break;
                case 6:
                    System.out.println("USUARIOS REGISTRADOS: ");
                    cine.mostrarClientes();
                    break;

                case 7: 

                break;    
                case 8:
                System.out.println("Lista de peliculas registradas: ");
                cine.mostrarPeliculas();
                break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
    }

