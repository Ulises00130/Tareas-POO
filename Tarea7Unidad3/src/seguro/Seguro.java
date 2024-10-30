package seguro;

public abstract class Seguro {
    protected String nombreTitular;
    protected double valorAsegurado;

    public Seguro(String nombreTitular, double valorAsegurado) {
        this.nombreTitular = nombreTitular;
        this.valorAsegurado = valorAsegurado;
    }

    public abstract double calcularPrima();

    public String detallesSeguro() {
        return "Titular: " + nombreTitular +
                "\nValor Asegurado: $" + valorAsegurado +
                "\nPrima Anual: $" + calcularPrima();
    }
}