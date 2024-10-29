import java.time.LocalDate;

public class PagoTarjeta extends Pago {
    LocalDate fechaVencimientoTarjeta;
    private String numeroTarjeta;

    public PagoTarjeta(int monto, LocalDate fechaVencimientoTarjeta, String numeroTarjeta) {
        super(monto);
        this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public void procesarPago() {
        validarPago();
        if (fechaVencimientoTarjeta.isBefore(LocalDate.now())) {
            System.out.println("No se pudo procesar el pago. Tarjeta vencida");
        } else {
            System.out.println("Pago Completado");
            System.out.println("Monto original: " + getMonto());
            System.out.println("Monto con descuento: " + (getMonto() - (getMonto() * obtenerDescuento(getMonto()))));
            System.out.println("Numero de tarjeta: " + numeroTarjeta);
        }
    }

    @Override
    public double obtenerDescuento (int monto) {
        if (fechaVencimientoTarjeta.isAfter(LocalDate.of(2030,1,1))) {
            if (numeroTarjeta.contains("888") && !numeroTarjeta.contains("A")) {
                return .12;
            } else {
                return .20;
            }
        } else if (fechaVencimientoTarjeta.isAfter(LocalDate.of(2028,1,1))) {
            if (numeroTarjeta.contains("999")) {
                return 0.8;
            } else {
                return .03;
            }
        } else {
            return 0.1;
        }
    }
}
