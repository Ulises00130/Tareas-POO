package salas;

import catalogopeliculas.Pelicula;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.time.LocalDateTime;


import java.util.ArrayList;
import java.util.List;

public class Sala {
    private int numeroSala;
    private int capacidad;
    private int filas;
    private int columnas;
    private List<Asiento> asientos;
    private Pelicula pelicula;

    // Getter y Setter para la película
    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala(int numeroSala, int filas, int columnas,int filasVIP, int filasPremium) {
        this.numeroSala = numeroSala;
        this.filas = filas;
        this.columnas = columnas;
        this.capacidad = filas * columnas;
        this.asientos = new ArrayList<>();
        inicializarAsientos(filasVIP, filasPremium);
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<Asiento> asientos) {
        this.asientos = asientos;
    }

    private void inicializarAsientos(int filasVIP, int filasPremium) {
        for (int fila = 1; fila <= filas; fila++) {
            char letraFila = (char) ('A' + (fila - 1));
            for (int columna = 1; columna <= columnas; columna++) {
                Rol tipoAsiento;

                // Asignar el tipo de asiento según las filas indicadas
                if (fila <= filasVIP) {
                    tipoAsiento = Rol.VIP;
                } else if (fila <= filasPremium + filasVIP) {
                    tipoAsiento = Rol.PREMIUM;
                } else {
                    tipoAsiento = Rol.NORMAL;
                }

                String idAsiento = letraFila + String.valueOf(columna);
                Asiento asiento = new Asiento(idAsiento, fila, columna, tipoAsiento);
                asientos.add(asiento);  // Agregar asiento a la lista
            }
        }
    }

    // Obtener el estado de todos los asientos en la sala
    public void mostrarEstadoAsientos() {
        for (Asiento asiento : asientos) {
            System.out.println("Asiento ID: " + asiento.getId() + ", Estado: " + asiento.getEstado() + ", Tipo: " + asiento.getTipo() + ", Precio: $" + asiento.getPrecio());
        }
    }

    // Método para reservar un asiento por ID
    public void reservarAsiento(String idAsiento) {
        for (Asiento asiento : asientos) {
            if (asiento.getId().equals(idAsiento)) {
                asiento.reservar();
                return;
            }
        }
        System.out.println("Asiento no encontrado o ya reservado.");
    }


    public int getCapacidad() {
        return capacidad;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public int contarAsientosVIP() {
        int count = 0;
        for (Asiento asiento : asientos) {
            if (asiento.getTipo().equals(Rol.VIP)) {
                count++;
            }
        }
        return count;
    }

    public int contarAsientosPremium() {
        int contador = 0;
        for (Asiento asiento : asientos) {
            if (asiento.getTipo().equals(Rol.PREMIUM)) {
                contador++;
            }
        }
        return contador;
    }
    public double calcularCostoTotalVIP() {
        double total = 0;
        for (Asiento asiento : asientos) {
            if (asiento.getTipo().equals(Rol.VIP)) {
                total += asiento.getPrecio(); // Precio es 400 para VIP
            }
        }
        return total;
    }

    public double calcularCostoTotalPremium() {
        double total = 0;
        for (Asiento asiento : asientos) {
            if (asiento.getTipo().equals(Rol.PREMIUM)) {
                total += asiento.getPrecio(); // Precio es 200 para Premium
            }
        }
        return total;
    }


    public double calcularCostoTotalTodosAsientos() {
        double total = 0;
        for (Asiento asiento : asientos) {
            total += asiento.getPrecio(); // Suma los precios de todos los asientos
        }
        return total;
    }


    public void mostrarMapaAsientos() {
        System.out.println("Mapa de asientos (D = Disponible, R = Reservado):\n");

        // Recorre las filas
        for (int fila = 1; fila <= filas; fila++) {
            char letraFila = (char) ('A' + (fila - 1));  // Convierte el número de fila a una letra (A, B, C...)

            System.out.print(letraFila + " ");

            for (int columna = 1; columna <= columnas; columna++) {
                String idAsiento = letraFila + String.valueOf(columna);
                Asiento asiento = buscarAsientoPorId(idAsiento);
                if (asiento != null) {
                    // Muestra [D] si el asiento está disponible, [R] si está reservado
                    if (asiento.getEstado().equals("Disponible")) {
                        System.out.print("[D] ");  // Asiento disponible
                    } else {
                        System.out.print("[R] ");  // Asiento reservado
                    }
                }
            }
            System.out.println();  // Salto de línea para la siguiente fila
        }
        System.out.println();  // Salto de línea final
    }

    public Asiento buscarAsientoPorId(String idAsiento) {
        for (Asiento asiento : asientos) {
            if (asiento.getId().equals(idAsiento)) {
                return asiento;
            }
        }
        return null;
    }

    public void mostrarDetallesSala(){
        System.out.println("Numero sala: " + this.numeroSala);
        System.out.println("Capacidad: " + this.capacidad);
    }

}

