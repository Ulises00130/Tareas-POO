public class EnvioNacional extends Envio {
    private double distanciaKm;

    public EnvioNacional(double costoBase, double peso, double distanciaKm) {
        super(costoBase, peso);
        this.distanciaKm = distanciaKm;
    }

    @Override
    public String calcularTiempoYCostoEntrega() {
        int tiempoEntrega = (int) Math.ceil(distanciaKm / 200);
        double costoTotal = costoBase;

        if (peso > 5) {
            costoTotal += costoBase * 0.05; // 5% adicional
        }

        return String.format("Envio Nacional - Costo Total: $%.2f, Tiempo de Entrega: %d días", costoTotal, tiempoEntrega);
    }
}