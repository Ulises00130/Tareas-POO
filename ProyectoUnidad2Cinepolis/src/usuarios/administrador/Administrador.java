package usuarios.administrador;

import cine.Cine;
import peliculas.Pelicula;
import salas.Sala;
import usuarios.Usuario;
import usuarios.utils.Rol;




import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {
    private Scanner scanner = new Scanner(System.in);
    public ArrayList<Sala> salas = new ArrayList<>();
    private String contrasenia;
    public ArrayList <Administrador> listaAdministradores= new ArrayList<>();

    public Administrador(String id, String nombre, String apellidos,String contrasenia, Rol rol) {
        super(id, nombre, apellidos, rol);
        this.contrasenia = contrasenia;

    }

    


}





