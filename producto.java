public class Producto {
    public String nombre;
    public double precio;
    public int stock;

    // Constructor que inicializa todos los atributos
    public Producto(String nombre, double precio, int stock) {
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
    }

    public Producto(String nombre, double precio) {
        this(nombre, precio, 0);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
    }
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
    }
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
    }

    public void aumentarStock(int cantidad) {
        if (cantidad > 0) {
            this.stock += cantidad;
        } else {
            throw new IllegalArgumentException("La cantidad a aumentar debe ser mayor que cero.");
        }
    }

        public void reducirStock(int cantidad) {
            if (cantidad > 0 && cantidad <= this.stock) {
                this.stock -= cantidad;
            } else {
                throw new IllegalArgumentException("La cantidad a reducir debe ser mayor que cero y menor o igual al stock actual.");
            }
        }

        public String toString() {
            return "Nombre: " + nombre + ", Precio: " + precio + ", Stock: " + stock;
        }
    }


