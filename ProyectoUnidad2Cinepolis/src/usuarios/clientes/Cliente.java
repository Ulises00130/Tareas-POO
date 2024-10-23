package usuarios.clientes;

import usuarios.Usuario;
import usuarios.utils.Rol;
import java.time.LocalDate;

public class Cliente extends Usuario {
    private LocalDate fechaDeNacimiento;
    private String direccion;
    private String curp;
    private String id;

    public Cliente(String id, String curp, String nombre, String apellidos, String direccion, LocalDate fechaNacimiento) {
        super(curp, nombre, apellidos, Rol.CLIENTE);
        this.direccion = direccion;
        this.id = id;
        this.fechaDeNacimiento = fechaNacimiento;
    }

    public String mostrarInformacion() {
        return "ID: " + this.id + ", Nombre: " + this.nombre + " " + this.apellidos + ", Dirección: " + this.direccion + ", Fecha de nacimiento: " + this.fechaDeNacimiento;
    }

    // Getters y setters
    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
