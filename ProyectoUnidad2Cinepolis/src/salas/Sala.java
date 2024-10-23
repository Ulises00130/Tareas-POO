package salas;

import java.util.ArrayList;

import cine.Horarios;
import peliculas.Pelicula;
import usuarios.utils.Rol;



public class Sala {
    private Asiento[][] asientos;
    private int filas;
    private int columnas;
    private String salaId;
    private Pelicula peliculaActual;
    private ArrayList<Horarios> horarios;

    public Sala(String salaId, int filas, int columnas) {
        this.salaId = salaId;
        this.filas = filas;
        this.columnas = columnas;
        this.asientos = new Asiento[filas][columnas];
        this.horarios = new ArrayList<>();
        inicializarAsientos();
    }

    public int getCapacidad (){
        return filas *columnas;
    }

    public boolean verificarDisponibilidadAsiento(String asientoId) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Asiento asiento = asientos[i][j];

                // Comparamos el ID del asiento con el ID proporcionado
                if (asiento.id.equals(asientoId)) {
                    // Verificamos si el asiento está disponible
                    return asiento.estado == Rol.DISPONIBLE;
                }
            }
        }        return false;
    }
    public void ocuparAsiento(String asientoId) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Asiento asiento = asientos[i][j];
                
                if (asiento.id.equals(asientoId)) {
                    asiento.estado = Rol.OCUPADO;
                    System.out.println("El asiento " + asientoId + " ha sido marcado como ocupado.");
                    return;
                }
            }
        }
        System.out.println("El asiento " + asientoId + " no existe.");
    }

    public Asiento buscarAsientoPorId(String asientoId) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Asiento asiento = asientos[i][j];
                if (asiento.id.equals(asientoId)) {
                    return asiento;  // Retorna el asiento encontrado
                }
            }
        }
        return null;  // Si no se encuentra el asiento
    }
    

    private void inicializarAsientos() {
        char filaLetra = 'A';  // Letra para las filas
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String id = filaLetra + Integer.toString(j + 1);
                Rol categoria;

                // Categorizar los asientos según la fila
                if (i < 2) {
                    categoria = Rol.VIP;  
                } else if (i < 5) {
                    categoria = Rol.PREMIUM;  
                } else {
                    categoria = Rol.NORMAL;  
                }

                // Crear un nuevo asiento
                asientos[i][j] = new Asiento(id, categoria);
            }
            filaLetra++;
        }
    }
      public void asignarPelicula(Pelicula pelicula) {
        this.peliculaActual = pelicula;
    }
   

    public void agregarHorario(Horarios horario) {
        this.horarios.add(horario);
    }

    public void mostrarHorarios() {
        System.out.println("Horarios disponibles en la sala: " + salaId + ":");
        if (horarios.isEmpty()) {
            System.out.println("No hay horarios asignados.");
        } else {
            for (Horarios horario : horarios) {
                System.out.println(horario.getHorario()); 
            }
        }
    }


    public void mostrarAsientos() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Asiento asiento = asientos[i][j];
                if (asiento != null) {
                    String estado = asiento.estado == Rol.OCUPADO ? "Ocupado" : "Disponible";
                    String categoria = asiento.categoria.toString();
                    System.out.print(asiento.id + "(" + estado + ", " + categoria + ") ");
                } else {
                    System.out.print("Asiento no asignado ");
                }
            }
            System.out.println();  
        }
    }
    public void mostrarPeliculaActual() {
        if (peliculaActual != null) {
            System.out.println("Película actual en la " + salaId + ": " + peliculaActual.getTitulo());
        } else {
            System.out.println("No hay ninguna película asignada a esta sala.");
        }
    }

    public class Asiento {
        private String id;
        private Rol estado;
        private Rol categoria;

        public Asiento(String id, Rol categoria) {
            this.id = id;
            this.categoria = categoria;
            this.estado = Rol.DISPONIBLE;  // Inicialmente, el asiento está disponible
        }
        public Rol getCategoria() {
            return categoria;
        }
    }


    public String getSalaId() {
        return salaId;
    
}
public ArrayList<Horarios> getHorarios() {
    return horarios;
}

public Pelicula getPeliculaActual() {
    return peliculaActual;
}
 



}
