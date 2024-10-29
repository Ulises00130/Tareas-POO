public abstract class Envio {
    protected double costoBase;
    protected double peso;

    public Envio(double costoBase, double peso) {
        this.costoBase = costoBase;
        this.peso = peso;
    }

    public abstract String calcularTiempoYCostoEntrega();

    public void validarPeso() {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que cero.");
        }
        System.out.println("Peso validado: " + peso + " kg");
    }
}
