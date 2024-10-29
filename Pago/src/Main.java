import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        PagoPaypal pagoPaypal = new PagoPaypal(200,"CB001", "juanjotitogmail.com");
        pagoPaypal.procesarPago();

        System.out.printf("+++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

        PagoTarjeta pagoTarjeta = new PagoTarjeta(10, LocalDate.of(2025,10,01), "CB001");
        pagoTarjeta.procesarPago();



        // Simulación de envío nacional
        System.out.println("Simulación de Envío Nacional:");
        Envio envioNacional = new EnvioNacional(300, 6.0, 600);
        try {
            envioNacional.validarPeso();
            System.out.println(envioNacional.calcularTiempoYCostoEntrega());
        } catch  (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

        // Simulación de envío internacional
        System.out.println("Simulación de Envío Internacional:");
        Envio envioInternacional = new EnvioInternacional(500, 12.0, "España");
        try{
            envioInternacional.validarPeso();
            System.out.println(envioInternacional.calcularTiempoYCostoEntrega());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
                }
            }
        }



















