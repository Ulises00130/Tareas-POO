package menu;

import usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdministrador {
private Scanner scanner = new Scanner(System.in);

    private ArrayList<String> obtenerDatosComun(Rol rol){
        String tipoUsuario = rol == Rol.PACIENTE ? "Paciente" : "Usuario";
        if(rol == Rol.PACIENTE){
            tipoUsuario = "Paciente";
        }else if (rol == Rol.MEDICO)
            tipoUsuario = "Medico";


        return null;






    }
}




