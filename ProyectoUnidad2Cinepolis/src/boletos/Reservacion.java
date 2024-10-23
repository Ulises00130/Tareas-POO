package boletos;

import cine.Horarios;
import peliculas.Pelicula;
import salas.Sala;
import usuarios.clientes.Cliente;
import dulceria.Producto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Reservacion {
    private String idReservacion;          
    private Cliente cliente;              
    private Sala sala;                     
    private ArrayList<String> boletos;     
    private ArrayList<Producto> productosAdicionales; 
    private double precioTotal;           
    private LocalDate fechaCompra;        
    private String tipoPago;             
    private boolean esReservacionCompleta; 

    private static final Scanner scanner = new Scanner(System.in); // Escáner para recibir entrada

    // Constructor para inicializar la reservación
    public Reservacion(String idReservacion, Cliente cliente, Sala sala) {
        this.idReservacion = idReservacion;
        this.cliente = cliente;
        this.sala = sala;
        this.boletos = new ArrayList<>();
        this.productosAdicionales = new ArrayList<>();
        this.precioTotal = 0.0;
        this.fechaCompra = LocalDate.now(); // Fecha actual
        this.esReservacionCompleta = false; // Comienza como no completada
    }






    // Métodos para obtener información de la reservación
    public String getIdReservacion() {
        return idReservacion;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public ArrayList<String> getBoletos() {
        return boletos;
    }

    public boolean isReservacionCompleta() {
        return esReservacionCompleta;
    }
}
