package peliculas;

//import salas.Sala;
import java.util.ArrayList;

public class Pelicula {
    public String id;
    public String titulo;
    public String genero;
    private String clasificacion;
    private int duracion; // en minutos
    private String sinopsis;
    private ArrayList<String> horarios = new ArrayList<>(); // Lista de horarios disponibles
    public ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
    
    public Pelicula(String id, String titulo, String genero, String clasificacion, int duracion, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.horarios = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setHorarios(ArrayList<String> horarios) {
        this.horarios = horarios;
    }

    public ArrayList<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public String mostrarDatosPelicula(){
        return "ID: "+this.id+" Titulo: "+this.titulo+" Genero: "+this.genero+" Clasificacion: "+this.clasificacion+" Duracion(en minutos:) "+this.duracion+" MINUTIS"+" Sinopsis: "+this.sinopsis;
    }
    

}
