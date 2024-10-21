package usuarios;

public enum Rol {
    VIP(400.0),    // Precio para asientos VIP
    PREMIUM(200.0), // Precio para asientos Premium
    NORMAL(100.0);  // Precio para asientos Normales

    private final double precio;

    // Constructor para asignar el precio a cada rol
    Rol(double precio) {
        this.precio = precio;
    }

    // Método para obtener el precio del rol
    public double getPrecio() {
        return precio;
    }
}
