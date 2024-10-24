package catalogopeliculas;

import java.util.ArrayList;
import java.util.List;

public class CatalogoPeliculas {
    private List<Pelicula> peliculas;

    // Constructor para inicializar la lista de películas
    public CatalogoPeliculas() {
        this.peliculas = new ArrayList<>();
    }


    public void agregarPelicula(Pelicula pelicula) {
        if (pelicula != null) {
            peliculas.add(pelicula);
            System.out.println("Película agregada: " + pelicula.getTitulo());
        } else {
            System.out.println("Error: La película no puede ser nula.");
        }
    }


    public void listarPeliculas() {
        System.out.println("Catálogo de Películas:");
        for (Pelicula pelicula : peliculas) {
            pelicula.mostrarDetallesPelicula();
            System.out.println("-------------------------");
        }
    }

    public Pelicula buscarPelicula(String id) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId().equals(id)) {
                return pelicula;
            }
        }
        return null;
    }

    }
