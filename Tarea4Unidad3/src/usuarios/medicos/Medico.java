package usuarios.medicos;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Medico extends Usuario {

    private String rfc;

    public Medico(String id, String nombre, String apellidos, LocalDate fechaNacimiento,String telefono, String rfc, String Contrasenia) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, Contrasenia, Rol.MEDICO);
        this.rfc = rfc;
    }

    public String getRfc() {
        return rfc;
    }
    public String mostrarDatosM(){
        String datos = String.format("id=%s, nombre=%s, año de nacimiento=%s, rfc: %s", id,nombre, fechaNacimiento,rfc);
        return datos;
    }
}