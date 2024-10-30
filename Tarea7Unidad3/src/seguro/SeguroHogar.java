package seguro;

public class SeguroHogar extends Seguro {
    private boolean zonaRiesgo;

    public SeguroHogar(String nombreTitular, double valorAsegurado, boolean zonaRiesgo) {
        super(nombreTitular, valorAsegurado);
        this.zonaRiesgo = zonaRiesgo;
    }

    @Override
    public double calcularPrima() {
        double primaBase = 500;
        double porcentajeValor = 0.02 * valorAsegurado;
        double prima = primaBase + porcentajeValor;

        if (zonaRiesgo) {
            prima += prima * 0.20; // Recargo del 20%
        }

        return prima;
    }
}