package usuarios.administrador;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Administrador extends Usuario {
    private int sueldo;
    private int aniosTrabajados;
    private String rfc;
    public Administrador(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String contrasenia, Rol rol, int Sueldo, int AniosTrabajados, String rfc) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, contrasenia, Rol.ADMIN);
        this.sueldo = Sueldo;
        this.aniosTrabajados = aniosTrabajados;
        this.rfc = rfc;
    }
}