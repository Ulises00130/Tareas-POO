package medicos;
import java.time.LocalDate;
public class Medico {
    public String id;
    public String nombre;
    public String apellidos;
    public LocalDate fechaNacimiento;
    private String telefono;
    private String rfc;
    public Medico(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String rfc) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.rfc = rfc;
    }
    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getRfc() {
        return rfc;
    }
    public String mostrarDatos(){
        String datos= String.format("/n id=%s,nombre:%s,apellidos:%s,fecha de nacimiento:%s,telefono:%s,rfc:%s",id,nombre
                ,apellidos,fechaNacimiento,telefono,rfc);
        return datos;
    }
}