public class Producto {
    private static int contadorIds = 0; // Contador estático para ID únicos

    public int id;
    public String nombre;
    public Double precio;
    public String descripcion;
    public int idCategoria;
    public int stock;

    public Producto(String nombre, Double precio, String descripcion, int idCategoria, int stock) {
        this.id = generarIdUnico();
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.idCategoria = idCategoria;
        this.stock = stock;
    }

    private int generarIdUnico() {
        return ++contadorIds; // Incrementa el contador para un nuevo ID
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public int getStock() {
        return stock;
    }

    public String mostrarProducto() {
        return String.format("Id: %d, Nombre: %s, Precio: %.2f, Descripción: %s, Id Categoría: %d, Stock: %d",
                id, nombre, precio, descripcion, idCategoria, stock);
    }
}
