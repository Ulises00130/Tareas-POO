package usuarios.pacientes;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Paciente extends Usuario {

    public String tipoSangre;
    public char sexo;

    public Paciente(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String tipoSangre, char sexo, String Contrasenia) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, Contrasenia, Rol.PACIENTE);
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
    }
    public String mostrarDatos(){
        String datos= String.format("/n id=%s,nombre:%s,apellido:%s,fecha de nacimiento:%s,tipo de sangre:%s,telefono:%s",id,nombre
                ,apellidos,fechaNacimiento,tipoSangre,telefono);
        return datos;
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

    public String getTipoSangre() {
        return tipoSangre;
    }

    public char getSexo() {
        return sexo;
    }
    public String getNumeroTelefono() {
        return this.telefono;
    }

}