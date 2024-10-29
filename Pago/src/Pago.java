public abstract class Pago {
    private int monto;

    public Pago(int monto) {
        this.monto = monto;
    }

    public abstract void procesarPago();

    public abstract double obtenerDescuento (int monto);

    public void validarPago(){
        if (monto <= 0) {
            System.out.println("Monto del pago invalido");
        }else {
            System.out.println("Monto del pago correcto");
        }
    }
    public int getMonto() {
        return monto;
    }
}
