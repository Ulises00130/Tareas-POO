package dulceria;

public class Producto {
    public String idProducto;
    public String nombre;
    public Double precio;

    public Producto(String idProducto, String nombre, Double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public void mostrarProducto() {
        System.out.println("idProducto = " + idProducto);
        System.out.println("nombre = " + nombre);
        System.out.println("precio = " + precio);
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String setIdProducto(String idProducto) {
        this.idProducto = idProducto;
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
