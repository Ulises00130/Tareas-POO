package salas;

import usuarios.utils.Rol;

public class Asiento {
    private String id;
    private int fila;
    private int columna;
    private String estado;  // "Disponible", "Reservado"
    private Rol tipo;  // "VIP", "Premium", "Normal"
    private double precio;

    public Asiento(String id, int fila, int columna, Rol tipo) {
        this.id = id;
        this.fila = fila;
        this.columna = columna;
        this.tipo = tipo;
        this.estado = "Disponible";
        if (tipo.equals(Rol.VIP)) {
            this.precio = 400.00;
        } else if (tipo.equals(Rol.PREMIUM)) {
            this.precio = 200.00;
        } else {
            this.precio = 100.00;  // Precio para asientos normales
        }
    }

    public String getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public Rol getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void reservar() {
        if (estado.equals("Disponible")) {
            estado = "Reservado";
        } else {
            System.out.println("El asiento ya está reservado.");
        }
    }
    public void liberar() {
        if (this.estado.equals("Reservado")) {
            this.estado = "Disponible";
        } else {
            System.out.println("El asiento " + id + " ya está disponible.");
        }
    }
    private double calcularPrecio() {
        switch (tipo) {
            case VIP:
                return 400;
            case PREMIUM:
                return 200;
            default:
                return 100;  // Precio para asientos normales
        }
    }
}
