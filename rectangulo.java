public class Rectangulo {
    private double largo;
    private double ancho;

    // Constructor
    public Rectangulo(double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    public double calcularArea(int largo, int ancho) {
        return largo * ancho;
    }

    public double calcularArea(double largo, double ancho) {
        return largo * ancho;
    }

    public double calcularPerimetro(int largo, int ancho) {
        return 2 * (largo + ancho);
    }

    public double calcularPerimetro(double largo, double ancho) {
        return 2 * (largo + ancho);
    }
}
