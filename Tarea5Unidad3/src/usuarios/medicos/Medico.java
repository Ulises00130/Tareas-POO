package usuarios.medicos;

import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;

public class Medico extends Usuario {

    private String rfc;

    public Medico(String id, String nombre, String apellidos, LocalDate fechaNacimiento,String telefono, String rfc, String Contrasenia,String email) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, Contrasenia, Rol.MEDICO,email);
        this.rfc = rfc;
    }

    public String getRfc() {
        return rfc;
    }
    public String mostrarDatosM(){
        String datos = String.format("id=%s, nombre=%s, año de nacimiento=%s, rfc: %s,telefono: %s,email: %s", id,nombre, fechaNacimiento,rfc,telefono,email);
        return datos;
    }
}