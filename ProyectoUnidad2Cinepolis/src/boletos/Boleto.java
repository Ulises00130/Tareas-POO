package boletos;

import peliculas.Pelicula;
import salas.Sala;
import usuarios.clientes.Cliente;

public class Boleto {
    String id;
    Pelicula pelicula;
    Sala sala;
    double precio;
    String tipoAsiento;
    Cliente cliente;
    boolean tieneDescuento;


    public Boleto(String id, Pelicula pelicula, String tipoAsiento, double precio) {
        this.id = id;
        this.pelicula = pelicula;
        this.tipoAsiento = tipoAsiento;
        this.precio = precio;
    }

    // Getters
    public String getId() {
        return id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isTieneDescuento() {
        return tieneDescuento;
    }
}
