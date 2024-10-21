package catalogopeliculas;

import salas.Sala;
import java.util.ArrayList;

public class Pelicula {
    private String id;
    private String titulo;
    private String genero;
    private String clasificacion;
    private int duracion; // en minutos
    private String sinopsis;
    private ArrayList<String> horarios = new ArrayList<>(); // Lista de horarios disponibles
    private Sala salaAsignada = null; // Nombre corregido: salaAsignada

    // Constructor
    public Pelicula(String id, String titulo, String genero, String clasificacion, int duracion, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.horarios = new ArrayList<>();
        this.salaAsignada = null;
    }

    // Método para mostrar detalles de la película
    public void mostrarDetallesPelicula() {
        System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Clasificación: " + clasificacion);
        System.out.println("Duración: " + duracion + " minutos");
        System.out.println("Sinopsis: " + sinopsis);
        System.out.println("Horarios disponibles: " + horarios);
        System.out.println("Sala asignada: " + (salaAsignada != null ? salaAsignada.getNumeroSala() : "No asignada"));
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public ArrayList<String> getHorarios() {
        return horarios;
    }

    public Sala getSalaAsignada() {
        return salaAsignada;
    }

    public void setSalaAsignada(Sala salaAsignada) {
        this.salaAsignada = salaAsignada;
    }

    // Sobrescribir toString para mostrar la película en la cartelera
    @Override
    public String toString() {
        String infoSala = (salaAsignada != null) ? "Sala #" + salaAsignada.getNumeroSala() : "Sin sala asignada";
        String infoHorarios = horarios.isEmpty() ? "Horarios no disponibles" : String.join(", ", horarios);

        return "Título: " + titulo +
                "\nGénero: " + genero +
                "\nClasificación: " + clasificacion +
                "\nDuración: " + duracion + " minutos" +
                "\nSinopsis: " + sinopsis +
                "\nSala asignada: " + infoSala +
                "\nHorarios: " + infoHorarios;
    }


}
