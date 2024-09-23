package medico;

public class Medico {
    public static int id;
    public static String nombre;
    public String apellidos;
    public String fechaNacimiento;
    private String telefono;
    private String rfc;

    public Medico(int id, String nombre, String apellidos, String fechaNacimiento, String telefono, String rfc) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.rfc = rfc;
    }

    public Medico(String idMedico, String nombreMedico, String apellidoMedico, String fechaNacimientoM, String numeroTelefonoM, char sexoM) {

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getRfc() {
        return rfc;
    }

    public String mostrarDatos(){
        String datos= String.format("/n id=%s,nombre:%s,apellido:%s,fecha de nacimiento:%s,telefono:%s",id,nombre
                ,apellidos,fechaNacimiento,telefono);
        return datos;
    }

}
