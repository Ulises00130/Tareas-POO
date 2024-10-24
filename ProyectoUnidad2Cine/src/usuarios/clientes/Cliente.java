package usuarios.clientes;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cliente extends Usuario {
public LocalDateTime fechaDeNacimiento;
public String direccion;
public String curp;


    public Cliente(String curp, String nombre, String apellidos, String direccion, LocalDate fechaNacimiento) {
        super(curp, nombre, apellidos, Rol.CLIENTE);
        this.direccion = direccion;
    }

    public LocalDateTime getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDateTime fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
