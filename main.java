import hospital.Hospital;
import medico.Medico;
import pacientes.Paciente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Clases de un Hospital
        -Pacientes
        -Medicos
        -Consultas
        Packetes Paciente clase paciente

         */
        Scanner scanner = new Scanner(System.in);
        Hospital hospital=new Hospital();
        int opcion = 0;
        while (opcion != 10) {
            System.out.println("\n** SISTEMA HOSPITAL**");
            System.out.println("1.Registrar Paciente ");
            System.out.println("2.Registrar Medico ");
            System.out.println("3.Registrar Consultorio ");
            System.out.println("4.Registrar Consulta ");
            System.out.println("5.Mostrar Pacientes ");
            System.out.println("6.Mostrar Medicos");
            System.out.println("7.Mostrar Consultorios");
            System.out.println("8. Mostrar consultas");
            System.out.println("9. Mostrar Paciente por Id");
            System.out.println("10.Mostrar Medico por Id");
            System.out.println("11.Mostrar Consultorio por Id");
            System.out.println("12. Salir");
            System.out.println("Selecciona una opción: ");
            opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nSeleccionaste la opción para Registrar Paciente");

                    String id=hospital.generarIdPaciente();
                    System.out.println(id);

                    System.out.println("Ingresa el nombre del paciente ");
                    String nombre= scanner.nextLine();

                    System.out.println("Ingresa el apellido del paciente ");
                    String apellido= scanner.nextLine();

                    System.out.println("Ingresa la fecha de nacimiento del paciente ");
                    String fechaNacimiento= scanner.nextLine();

                    System.out.println("Ingresa el tipo de sangre del paciente ");
                    String tipoSangre= scanner.nextLine();

                    System.out.println("Ingresa el telefono del paciente ");
                    String numeroTelefono= scanner.nextLine();

                    System.out.println("Ingresa el sexo del paciente ");
                    String sexoString= scanner.nextLine();
                    char sexo= sexoString.charAt(0);
                    Paciente paciente =new Paciente(id,nombre,apellido,fechaNacimiento,tipoSangre,numeroTelefono,sexo);
                    hospital.registrarPaciente(paciente);
                    System.out.println(" Paciente registrado correctamente ");
                    break;
                case 2:
                    System.out.println("\nSeleccionaste la opción para Registrar Medico");

                    String idMedico=hospital.generarIdMedico();
                    System.out.println(idMedico);

                    System.out.println("Ingresa el nombre del medico ");
                    String nombreMedico= scanner.nextLine();

                    System.out.println("Ingresa el apellido del Medico ");
                    String apellidoMedico= scanner.nextLine();

                    System.out.println("Ingresa la fecha de nacimiento del Medico ");
                    String fechaNacimientoM= scanner.nextLine();

                    System.out.println("Ingresa el telefono del Medico ");
                    String numeroTelefonoM= scanner.nextLine();

                    System.out.println("Ingresa el sexo del Medico ");
                    String sexoStringM= scanner.nextLine();
                    char sexoM= sexoStringM.charAt(0);
                    Medico medico =new Medico(idMedico,nombreMedico,apellidoMedico,fechaNacimientoM,numeroTelefonoM,sexoM);
                    hospital.registrarMedico(medico);
                    System.out.println(" Medico registrado correctamente ");
                    break;
                case 3:
                    System.out.println("\nSeleccionaste la opción para Registrar Consultorio ");
                    break;

                case 4:
                    System.out.println("\nSeleccionaste la opción para Registrar Consulta ");
                    break;
                case 5:
                    System.out.println("\nSeleccionaste la opción para Mostrar Pacientes ");

                    break;
                case 6:
                    System.out.println("\nSeleccionaste la opción para Mostrar Medicos");
                    break;

                case 7:
                    System.out.println("\nSeleccionaste la opción para Mostrar Consultorios");
                    break;
                case 8:
                    System.out.println("\nSeleccionaste la opción para Mostrar Consulta");
                    break;
                case 9:
                    System.out.println("/nSeleccionaste la opcion de Mostrar Paciente por Id ingresalo");
                    String idPaciente =scanner.nextLine();

                    hospital.mostrarPacientePorId(idPaciente);
                    break;

                case 10:
                    System.out.println("/nSeleccionaste la opcion de Mostrar Medicos");
                    idMedico = scanner.nextLine();


                case 11:
                    System.out.println("/nSeleccionaste la opcion de Mostrar Consultorios");
                    String idConsultorio =scanner.nextLine();

                case 12:
                    System.out.println("Hasta luego");
                    return;
            }
        }
    }
}