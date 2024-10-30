package seguro;

public class SeguroVida extends Seguro {
    private int edadTitular;

    public SeguroVida(String nombreTitular, double valorAsegurado, int edadTitular) {
        super(nombreTitular, valorAsegurado);
        this.edadTitular = edadTitular;
    }

    @Override
    public double calcularPrima() {
        double primaBase = 400;
        double porcentajeValor = 0.015 * valorAsegurado;
        double prima = primaBase + porcentajeValor;

        if (edadTitular > 60) {
            prima += prima * 0.25; // Recargo del 25%
        }

        return prima;
    }
}