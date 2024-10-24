package menu;

import hospital.Hospital;
import usuarios.pacientes.Paciente;

import java.util.Scanner;

public class MenuPaciente {
    private Scanner scanner = new Scanner(System.in);
    public void MostrarMenu(Paciente paciente, Hospital hospital) {
        private void mostrarMenuPaciente(Paciente paciente) {
            int opcion = 0;

            while (opcion != 3) {
                System.out.println("\n**SISTEMA HOSPITAL**");
                System.out.println("1.- Ver mis consultas");
                System.out.println("2.- Ver información personal");
                System.out.println("3.- Salir");
                System.out.print("Selecciona una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        hospital.verConsultasPaciente(paciente.getId());
                        break;
                    case 2:
                        System.out.println(paciente.verInformacionPersonal());
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
}
