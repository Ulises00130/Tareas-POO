package pacientes;

public class Paciente {
    public int id;
    public String nombre;
    public String apellidos;
    public String fechaNacimiento;
    private String telefono;
    public String tipoSangre;
    public char sexo;

    public Paciente(int id, String nombre, String apellidos, String fechaNacimiento, String telefono, String tipoSangre, char sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
    }
}
