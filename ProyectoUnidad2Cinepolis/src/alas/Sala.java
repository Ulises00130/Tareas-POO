package salas;

import usuarios.utils.Rol;


public class Sala {
    private Asiento[][] asientos;
    private int filas = 10;
    private int columnas = 10;
    private String salaId;

    public Sala(String salaId, int filas, int columnas) {
        this.salaId = salaId;
        asientos = new Asiento[filas][columnas];
        inicializarAsientos();  // Inicializar los asientos
    }

    // Método para inicializar los asientos (ya existente en tu código)
    private void inicializarAsientos() {
        char filaLetra = 'A';  // Letra para las filas
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String id = filaLetra + Integer.toString(j + 1);
                
                Rol categoria;
                if (i < 2) {
                    categoria = Rol.VIP;  
                } else if (i < 5) {
                    categoria = Rol.PREMIUM;  
                } else {
                    categoria = Rol.NORMAL;  
                }
                
                asientos[i][j] = new Asiento(id, categoria);
            }
            filaLetra++;
        }
    }

    // Método mostrarAsientos debe ser público
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
            System.out.println();  // Salto de línea por fila
        }
    }

    private class Asiento {
        private String id;
        private Rol estado;
        private Rol categoria;

        public Asiento(String id, Rol categoria) {
            this.id = id;
            this.categoria = categoria;
            this.estado = Rol.DISPONIBLE;  // Inicialmente, el asiento está disponible
        }
    }
}


