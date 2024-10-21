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

    // Método para modificar una película en el catálogo
    public void modificarPelicula(String id, String nuevoTitulo, String nuevoGenero, String nuevaClasificacion, int nuevaDuracion, String nuevaSinopsis) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId().equals(id)) {
                // Corrección: Utilizar métodos set en lugar de get
                pelicula.getTitulo(nuevoTitulo);
                pelicula.getGenero(nuevoGenero);
                pelicula.getClasificacion(nuevaClasificacion);
                pelicula.getDuracion(nuevaDuracion);
                pelicula.getSinopsis(nuevaSinopsis);
                System.out.println("Película modificada: " + nuevoTitulo);
                return;
            }
        }
        System.out.println("Película no encontrada.");
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
