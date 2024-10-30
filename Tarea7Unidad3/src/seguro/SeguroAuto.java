package seguro;

public class SeguroAuto extends Seguro {
    private int edadTitular;

    public SeguroAuto(String nombreTitular, double valorAsegurado, int edadTitular) {
        super(nombreTitular, valorAsegurado);
        this.edadTitular = edadTitular;
    }

    @Override
    public double calcularPrima() {
        double primaBase = 300;
        double porcentajeValor = 0.05 * valorAsegurado;
        double prima = primaBase + porcentajeValor;

        if (edadTitular < 25) {
            prima += prima * 0.15; // Recargo del 15%
        }

        return prima;
    }
}