package usuarios.clientes;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDateTime;

public class Cliente extends Usuario {
public LocalDateTime fechaDeNacimiento;
public String direccion;
public String curp;
    public Cliente(String id, String nombre, String apellidos, Rol rol, LocalDateTime fechaDeNacimiento, String direccion, String curp) {
        super(id, nombre, apellidos, Rol.CLIENTE);
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.direccion = direccion;
        this.curp = curp;
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
