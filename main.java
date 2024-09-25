import consultorios.Consultorio;
import hospital.Hospital;
import medicos.Medico;
import pacientes.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital=new Hospital();
        //Medico medico = new Medico();
        int opcion = 0;
        while (opcion != 11) {
            System.out.println("\n*** SISTEMA HOSPITAL*");
            System.out.println("1.Registrar Paciente ");
            System.out.println("2.Registrar Medico ");
            System.out.println("3.Registrar Consultorio ");
            System.out.println("4.Registrar Consulta ");
            System.out.println("5.Mostrar Pacientes ");
            System.out.println("6.Mostrar Medicos");
            System.out.println("7.Mostrar Consultorios");
            System.out.println("8. Mostrar consultas");
            System.out.println("9. Mostrar Paciente por Id");
            System.out.println("10. Mostrar Medicos por Id");
            System.out.println("11. Salir");
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

                    System.out.println("Ingresa el año de nacimiento del paciente: ");
                    int anio = scanner.nextInt();

                    System.out.println("Ingresa el mes de nacimiento del paciente: ");
                    int mes = scanner.nextInt();

                    System.out.println("Ingresa el dia de nacimiento del paciente: ");
                    int dia = scanner.nextInt();

                    LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
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

                    System.out.println("Ingrese el nombre del medico ");
                    String nombreMedico= scanner.nextLine();
                    System.out.println("Ingresa el apellido del medico ");
                    String apellidoMedico= scanner.nextLine();
                    System.out.println("Ingresa el año de nacimiento del paciente: ");
                    int anioMedico = scanner.nextInt();

                    System.out.println("Ingresa el mes de nacimiento del paciente: ");
                    int mesMedico = scanner.nextInt();

                    System.out.println("Ingresa el dia de nacimiento del paciente: ");
                    int diaMedico = scanner.nextInt();
                    LocalDate anoMedico = LocalDate.of(anioMedico, mesMedico, diaMedico );
                    String idMedico = hospital.generarIdMedico(nombreMedico, String.valueOf(anioMedico));
                    Medico medico = new Medico(idMedico, apellidoMedico,nombreMedico, anoMedico);
                    hospital.registrarMedico(medico);

                    break;
                case 3:
                    System.out.println("\nSeleccionaste la opción para Registrar Consultorio ");
                    String idConsultorio = hospital.generarIdConsultorio();
                    System.out.println("Ingrese el piso del consultorio: ");
                    int piso = scanner.nextInt();
                    System.out.println("Ingrese el numero del consultorio: ");
                    int numeroConsultorio= scanner.nextInt();
                    Consultorio consultorio = new Consultorio(idConsultorio,piso,numeroConsultorio);
                    hospital.registrarConsultorio(consultorio);
                    break;
                case 4:
                    System.out.println("\nSeleccionaste la opción para Registrar Consulta ");
                    String idConsulta=hospital.generarIdConsulta();
                    System.out.println(idConsulta);

                    System.out.println("Ingresa el dia de la consulta deseada: ");
                    int diaConsulta = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ingresa el mes de la consulta deseada: ");
                    int mesConsulta = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingresa el año de la consulta deseada: ");
                    int anioConsulta = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ingrese la hora de la consulta deseada: ");
                    int horaConsulta = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Ingresa los minutos de la consulta deseada: ");
                    int minutosConsulta = scanner.nextInt();
                    scanner.nextLine();

                    LocalDateTime fechaConsulta = LocalDateTime.of(anioConsulta, mesConsulta, diaConsulta, horaConsulta, minutosConsulta);
                    System.out.println("Ingresa el id del paciente: ");
                    String pacienteId = scanner.nextLine();

                    Paciente pacienteConsulta = hospital.obtenerPacientePorId(pacienteId);
                    System.out.println("Ingresa el id del medico: ");
                    String medicoId = scanner.nextLine();

                    Medico medicoConsulta = hospital.obtenerMedicoPorId(medicoId);

                    break;

                case 5:
                    System.out.println("\nSeleccionaste la opción para Mostrar Pacientes ");
                    hospital.mostrarPacientes();
                    break;
                case 6:
                    System.out.println("\nSeleccionaste la opción para Mostrar Medicos");
                    hospital.mostrarMedicos();
                    break;

                case 7:
                    System.out.println("\nSeleccionaste la opción para Mostrar Consultorios");
                    hospital.mostrarConsultorios();
                    break;
                case 8:
                    System.out.println("\nSeleccionaste la opción para Mostrar Consulta por id");
                    hospital.mostarConsultaPorId(idConsulta);
                    System.out.println(idConsulta);
                    break;

                case 9:
                    System.out.println("/nSeleccionaste la opcion de Mostrar Paciente por Id ingresalo");
                    String idPaciente =scanner.nextLine();

                    hospital.mostrarPacientePorId(idPaciente);
                    System.out.println(idPaciente);
                    break;
                case 10:
                    System.out.println("\nSeleccionaste la opcion de mostrar Medicos por su ID, ingresalo:");
                    String idDeConsultorio =scanner.nextLine();
                    hospital.mostrarMedicoPorId(idDeConsultorio);
                    System.out.println(idDeConsultorio);
                    break;
                case 11:
                    System.out.println("Hasta luego");
                    return;
            }
        }
    }
}