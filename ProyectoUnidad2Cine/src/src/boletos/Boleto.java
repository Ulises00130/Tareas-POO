package boletos;

public class Boleto {
    private String id;
    private String peliculaId;
    private String salaId;
    public double precio;
    private String asientoId;
    public String tipoAsiento;
    public String clienteId;
    private boolean tieneDescuento;

    public Boleto(String id, String peliculaId, String salaId, double precio, String asientoId, String tipoAsiento, String clienteId, boolean tieneDescuento) {
        this.id = id;
        this.peliculaId = peliculaId;
        this.salaId = salaId;
        this.precio = precio;
        this.asientoId = asientoId;
        this.tipoAsiento = tipoAsiento;
        this.clienteId = clienteId;
        this.tieneDescuento = tieneDescuento;

    }

    public String getId() {
        return id;
    }

    public String getPeliculaId() {
        return peliculaId;
    }

    public String getSalaId() {
        return salaId;
    }

    public double getPrecio() {
        return precio;
    }

    public String getAsientoId() {
        return asientoId;
    }

    public String getTipoAsiento() {
        return tipoAsiento;
    }

    public String getClienteId() {
        return clienteId;
    }

    public boolean TieneDescuento() {
        return tieneDescuento;
    }

}