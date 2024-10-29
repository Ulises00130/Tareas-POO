class EnvioInternacional extends Envio {
    private String destino;

    public EnvioInternacional(double costoBase, double peso, String destino) {
        super(costoBase, peso);
        this.destino = destino;
    }

    @Override
    public String calcularTiempoYCostoEntrega() {
        int tiempoEntrega = 10; // Tiempo fijo de 10 días

        if (peso > 10) {
            tiempoEntrega += 3; // 3 días adicionales
        }

        double costoTotal = costoBase + (costoBase * 0.20); // 20% adicional

        return String.format("Envio Internacional - Costo Total: $%.2f, Tiempo de Entrega: %d días", costoTotal, tiempoEntrega);
    }
}