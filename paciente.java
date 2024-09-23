package pacientes;

public class Paciente {
    public String id;
    public String nombre;
    public String apellidos;
    public String fechaNacimiento;
    private String telefono;
    public String tipoSangre;
    public char sexo;

    public Paciente(String id, String nombre, String apellidos, String fechaNacimiento, String telefono, String tipoSangre, char sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
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

    public String getFechaNacimiento() {
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

}