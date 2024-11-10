class Habitacion {
    public double getPrecioPorNoche;
    private String tipo;
    private double precioPorNoche;
    private boolean disponible;

    public Habitacion(String tipo, double precioPorNoche) {
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = true;
    }

    public void reservar(int noches) throws HabitacionNoDisponibleException, NumeroDeNochesInvalidoException {
        if (!disponible) {
            throw new HabitacionNoDisponibleException("La habitación ya está ocupada.");
        }
        if (noches < 1) {
            throw new NumeroDeNochesInvalidoException("El número de noches debe ser al menos 1.");
        }
        disponible = false; }

    public void liberar() {
        disponible = true;
    }

    public void mostrarDetalles() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Precio por noche: " + precioPorNoche);
        System.out.println("Disponibilidad: " + (disponible ? "Disponible" : "No disponible"));
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getTipo() {
        return tipo;

    }

    class HabitacionNoDisponibleException extends Exception {
        public HabitacionNoDisponibleException(String message) {
            super(message);
        }
    }


    class NumeroDeNochesInvalidoException extends Exception {
        public NumeroDeNochesInvalidoException(String message) {
            super(message);
        }
    }
}