public class PagoPaypal extends Pago {
    private String numeroDeCuenta;
    private String email;

    public PagoPaypal(int monto, String numeroDeCuenta, String email) {
        super(monto);
        this.numeroDeCuenta = numeroDeCuenta;
        this.email = email;
    }

    @Override
    public void procesarPago() {
        validarPago();
        if (!email.contains("@")) {
            System.out.println("Correo invalido");
        } else {
            System.out.println("Pago completado");
            System.out.println("Monto original: " + getMonto());
            System.out.println("Monto con descuento: " + (getMonto() - (getMonto() * obtenerDescuento(getMonto()))));
            System.out.println("Correo usuario: " + email);
            System.out.println("Numero de cuenta: " + numeroDeCuenta);
        }
    }

    @Override
    public double obtenerDescuento(int monto) {
        if (monto > 100){
            if (numeroDeCuenta.contains("001")) {
                return 0.10;
            } else {
                return 0.05;
            }
        }
        return 0.2;
    }
}
