package menu;

import consultas.Consulta;
import hospital.Hospital;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuMedico( Hospital hospital) {
    private Scanner scanner = new Scanner(System.in);
    private void mostrarMenuMedico() {
            System.out.println("\n**SISTEMA HOSPITAL**");
            System.out.println("1.- Ver mis consultas");
            System.out.println("2.- Ver información personal");
            System.out.println("3.- Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();


}

public void ProcesarDatosMenu(){

            switch (opcion) {
                case 1:
                    ArrayList<Consulta> consultas = hospital.verConsultasPorMedico(medico.getId());
                    if (consultas.isEmpty()) {
                        System.out.println("No tienes consultas programadas.");
                    } else {
                        for (Consulta consulta : consultas) {
                            System.out.println(consulta);
                        }
                    }
                    break;
                case 2:
                    System.out.println(medico.verInformacionPersonal());
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
        }
