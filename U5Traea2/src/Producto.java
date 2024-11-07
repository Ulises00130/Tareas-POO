public class Producto {
         String nombre;
         double precio;
         int cantidad;

        public Producto(String nombre, double precio, int cantidad) throws ProductoInvalidoException, PrecioInvalidoException, CantidadInvalidaException {
            if (nombre == null || nombre.isEmpty()) {
                throw new ProductoInvalidoException("El nombre del producto no puede ser nulo o vacío.");
            }
            if (precio <= 0) {
                throw new PrecioInvalidoException("El precio del producto debe ser mayor que cero.");
            }
            if (cantidad < 0) {
                throw new CantidadInvalidaException("La cantidad del producto no puede ser negativa.");
            }
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }

        public double calcularValorTotal() {
            return cantidad * precio;
        }

        public void mostrarDetalles() {
            System.out.println("Nombre del producto: " + nombre);
            System.out.println("Precio del producto: " + precio);
            System.out.println("Cantidad disponible: " + cantidad);
            System.out.println("Valor total del inventario: " + calcularValorTotal());
        }
    }
// Excepción personalizada
class ProductoInvalidoException extends Exception {
    public ProductoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

// Excepción personalizada
class PrecioInvalidoException extends Exception {
    public PrecioInvalidoException(String mensaje) {
        super(mensaje);
    }
}

// Excepción personalizada
class CantidadInvalidaException extends Exception {
    public CantidadInvalidaException(String mensaje) {
        super(mensaje);
    }
}



