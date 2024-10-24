package boletos;

import dulceria.Producto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Compras {
    public int idCompra;
    public LocalDateTime fechaDeCompra;
    public ArrayList <Boleto> boletos = new ArrayList<>();
    public ArrayList <Producto> productos = new ArrayList<>();
    public String metodoPago;
    public int precioTotal;

    public Compras(int idCompra, LocalDateTime fechaDeCompra, ArrayList<Boleto> boletos, ArrayList<Producto> productos, String metodoPago, int precioTotal) {
        this.idCompra = idCompra;
        this.fechaDeCompra = fechaDeCompra;
        this.boletos = boletos;
        this.productos = productos;
        this.metodoPago = metodoPago;
        this.precioTotal = precioTotal;

    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public LocalDateTime getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(LocalDateTime fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    public ArrayList<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(ArrayList<Boleto> boletos) {
        this.boletos = boletos;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }
}
