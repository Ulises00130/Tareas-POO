package usuarios.pacientes;

import expedientes.Expediente;
import usuarios.Usuario;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;

public class Paciente extends Usuario {

    public String tipoSangre;
    public char sexo;
    public Expediente expediente;
    public ArrayList<Expediente> expedientes = new ArrayList<>();

    public Paciente(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String tipoSangre, char sexo, String Contrasenia,String email) {
        super(id, nombre, apellidos, fechaNacimiento, telefono, Contrasenia, Rol.PACIENTE,email);
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
    }

    //METODOS
    public String mostrarDatos(){
        String datos= String.format("/n id=%s,nombre:%s,apellido:%s,fecha de nacimiento:%s,tipo de sangre:%s,telefono:%s,email: %s",id,nombre
                ,apellidos,fechaNacimiento,tipoSangre,telefono,email);
        return datos;
    }

    public void registrarExpediente(Expediente expediente) {
        this.expedientes.add(expediente);
    }

    //
    public String getTipoSangre() {
        return tipoSangre;
    }

    public char getSexo() {
        return sexo;
    }
    public String getNumeroTelefono() {
        return this.telefono;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}