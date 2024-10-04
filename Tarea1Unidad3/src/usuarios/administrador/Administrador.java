package usuarios.administrador;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Administrador extends Usuario {

    private double sueldo;
    private String rfc;
    private int anosTrabajados;

    public Administrador(String id, String nombre, String apellidos, LocalDate fechaNacimiento,
                         String telefono, String rfc, double sueldo, int anosTrabajados, String contrasenia) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, contrasenia, Rol.ADMINISTRADOR);
        this.sueldo = sueldo;
        this.rfc = rfc;
        this.anosTrabajados = anosTrabajados;
    }

    public double getSueldo() {
        return sueldo;
    }

    public String getRfc() {
        return rfc;
    }

    public int getAnosTrabajados() {
        return anosTrabajados;
    }

    public String mostrarDatosA() {
        return String.format("ID: %s, Nombre: %s %s, Fecha de nacimiento: %s, RFC: %s, Sueldo: %.2f, Años trabajados: %d",
                id, nombre, apellidos, fechaNacimiento, rfc, sueldo, anosTrabajados);
    }
}

