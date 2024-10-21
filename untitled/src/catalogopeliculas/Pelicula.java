package catalogopeliculas;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    private String id;
    private String titulo;
    private String genero;
    private String clasificacion;
    private int duracion; // en minutos
    private String sinopsis;
    private ArrayList<String> horarios= new ArrayList<>(); // Lista de horarios disponibles

    // Constructor
    public Pelicula(String id, String titulo, String genero, String clasificacion, int duracion, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.horarios = new ArrayList<>();
    }

    // Métodos para mostrar detalles de la película
    public void mostrarDetallesPelicula() {
        System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Clasificación: " + clasificacion);
        System.out.println("Duración: " + duracion + " minutos");
        System.out.println("Sinopsis: " + sinopsis);
        System.out.println("Horarios disponibles: " + horarios);
    }

    // Métodos para agregar y modificar horarios
    public void agregarHorario(String horario) {
        horarios.add(horario);
    }

    public void modificarHorario(int index, String nuevoHorario) {
        if (index >= 0 && index < horarios.size()) {
            horarios.set(index, nuevoHorario);
        } else {
            System.out.println("Índice de horario no válido.");
        }
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void getTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void getGenero(String genero) {
        this.genero = genero;
    }

    public void getClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void getDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void getSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }


    public String getTitulo() {
        return titulo;

    }
}



