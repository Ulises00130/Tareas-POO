package cine;

import catalogopeliculas.Pelicula;
import salas.Asiento;
import salas.Sala;
import usuarios.Usuario;
import usuarios.administrador.Administrador;
import usuarios.utils.Rol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cine {
    public ArrayList <Administrador> listaAdministradores= new ArrayList<>();
    public ArrayList <Pelicula> listaPeliculas= new ArrayList<>();
    public ArrayList <Sala> listaSalas= new ArrayList<>();
    public ArrayList <Usuario> listaUsuarios= new ArrayList<>();
    private static final int MAX_SALAS = 5;
    private Scanner scanner = new Scanner(System.in);
    public Sala sala;
    public Cine (){
        Administrador administrador = new Administrador("272167","Hugo","Perez","123", Rol.ADMINISTRADOR);
        this.listaAdministradores.add(administrador);
        this.listaUsuarios.add(administrador);
    }
    //Cine cine = new Cine();
    public void asignarSalas() {
        Scanner scanner = new Scanner(System.in);

        // Permitir al administrador crear hasta 5 salas
        for (int i = 1; i <= MAX_SALAS; i++) {
            System.out.println("Configurando Sala #" + i);

            // Solicitar el número de filas y columnas para la sala
            System.out.print("Ingrese el número de filas para la sala: ");
            int filas = scanner.nextInt();

            System.out.print("Ingrese el número de columnas para la sala: ");
            int columnas = scanner.nextInt();

            // Solicitar las filas que serán VIP, Premium, y las restantes serán Normales
            System.out.print("Ingrese el número de filas que serán VIP: ");
            int filasVIP = scanner.nextInt();

            System.out.print("Ingrese el número de filas que serán Premium: ");
            int filasPremium = scanner.nextInt();

            // Crear la sala con las dimensiones especificadas y los tipos de asiento definidos
            Sala nuevaSala = new Sala(i, filas, columnas, filasVIP, filasPremium);

            // Agregar la sala a la lista de salas
            listaSalas.add(nuevaSala);

            System.out.println("Sala #" + i + " configurada con " + filas + " filas y " + columnas + " columnas.");
            System.out.println();

            // Mostrar el mapa de asientos después de configurar la sala
            System.out.println("Mapa de Asientos para la Sala #" + i);
            nuevaSala.mostrarMapaAsientos(); // Aquí llamas al método para mostrar los asientos

            // Mostrar el costo total de asientos VIP y Premium
            System.out.println("Costo total de los asientos VIP: $" + nuevaSala.calcularCostoTotalVIP());
            System.out.println("Costo total de los asientos Premium: $" + nuevaSala.calcularCostoTotalPremium());
        }
        System.out.println("Se han configurado todas las salas.");
    }
    public void consultarReservas() {
        if (listaSalas.isEmpty()) {
            System.out.println("No hay salas configuradas.");
            return;
        }

        // Recorre todas las salas y muestra el mapa de asientos
        for (Sala sala : listaSalas) {
            System.out.println("Estado de los asientos para la Sala #" + sala.getNumeroSala() + ":");
            sala.mostrarMapaAsientos();
            System.out.println("--------------------------------------------------------");
        }
    }


    public ArrayList<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }


    public void setListaAdministradores(ArrayList<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public ArrayList<Sala> getListaSalas() {
        return listaSalas;
    }

    public void setListaSalas(ArrayList<Sala> listaSalas) {
        this.listaSalas = listaSalas;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    public void agregarPelicula(Pelicula pelicula) {
        this.listaPeliculas.add(pelicula);
    }

    public void liberarAsientoEnSala(int numeroSala, String idAsiento) {
        Sala sala = buscarSalaPorNumero(numeroSala);
        if (sala != null) {
            Asiento asiento = sala.buscarAsientoPorId(idAsiento);
            if (asiento != null && asiento.getEstado().equals("Reservado")) {
                asiento.liberar();
                System.out.println("El asiento " + idAsiento + " ha sido liberado.");
            } else {
                System.out.println("El asiento no está reservado o no existe.");
            }
        } else {
            System.out.println("Sala no encontrada.");
        }
    }
    private Sala buscarSalaPorNumero(int numeroSala) {
        for (Sala sala : listaSalas) {
            if (sala.getNumeroSala() == numeroSala) {
                return sala;
            }
        }
        return null;  // Si no se encuentra la sala
    }

    public void registrarPelicula() {
        System.out.println("\nRegistro de Película:");

        System.out.print("Ingrese el ID de la película: ");
        String id = scanner.nextLine();

        System.out.print("Ingrese el título de la película: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese el género de la película: ");
        String genero = scanner.nextLine();

        System.out.print("Ingrese la clasificación de la película (Ej: PG-13, R, etc.): ");
        String clasificacion = scanner.nextLine();

        System.out.print("Ingrese la duración de la película (en minutos): ");
        int duracion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese la sinopsis de la película: ");
        String sinopsis = scanner.nextLine();


        Pelicula nuevaPelicula = new Pelicula(id, titulo, genero, clasificacion, duracion, sinopsis);

        // Añadir la película a la lista en la clase Cine
        agregarPelicula(nuevaPelicula);

        System.out.println("\nPelícula registrada exitosamente:");
        System.out.println(nuevaPelicula);
    }

    public void asignarPeliculaASala() {
        if (listaPeliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
            return;
        }

        if (listaSalas.isEmpty()) {
            System.out.println("No hay salas disponibles.");
            return;
        }

        System.out.println("\nAsignar película a una sala:");

        // Mostrar las películas registradas
        for (int i = 0; i < listaPeliculas.size(); i++) {
            Pelicula pelicula = listaPeliculas.get(i);
            System.out.println((i + 1) + ". " + pelicula.getTitulo());
        }

        System.out.print("Seleccione el número de la película que desea asignar: ");
        int seleccionPelicula = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (seleccionPelicula > 0 && seleccionPelicula <= listaPeliculas.size()) {
            Pelicula peliculaSeleccionada = listaPeliculas.get(seleccionPelicula - 1);

            // Mostrar las salas disponibles
            for (int i = 0; i < listaSalas.size(); i++) {
                Sala sala = listaSalas.get(i);
                System.out.println((i + 1) + ". Sala #" + sala.getNumeroSala() + " (Capacidad: " + sala.getCapacidad() + ")");
            }

            System.out.print("Seleccione el número de la sala para asignar la película: ");
            int seleccionSala = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            if (seleccionSala > 0 && seleccionSala <= listaSalas.size()) {
                Sala salaSeleccionada = listaSalas.get(seleccionSala - 1);
                // Asignar la película a la sala
                salaSeleccionada.setPelicula(peliculaSeleccionada);
                System.out.println("Película '" + peliculaSeleccionada.getTitulo() + "' asignada a la Sala #" + salaSeleccionada.getNumeroSala());
            } else {
                System.out.println("Selección de sala no válida.");
            }
        } else {
            System.out.println("Selección de película no válida.");
        }
    }


    public ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }


    public Sala getSala(int numeroSala) {

        return null;
    }

    public List<Sala> getSalasDisponibles(Pelicula peliculaSeleccionada) {

        return List.of();
    }

    public Pelicula buscarPelicula(String tituloPelicula) {
        return null;
    }
}