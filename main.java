import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import pacientes.Paciente;
import medicos.Medico;
import hospital.ValidadorHospital;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void Main(String[] args) {
Scanner scanner = new Scanner(System.in);
Hospital hospital=new Hospital();
int opcion = 0;
while (opcion != 12) {
    System.out.println("\n*** SISTEMA HOSPITAL***");
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
            //String fechaNacimiento= scanner.nextLine();
            System.out.println("Ingresa año ");
            int ano= scanner.nextInt();
            System.out.println("Ingresa mes ");
            int mes= scanner.nextInt();
            System.out.println("Ingresa dia ");
            int dia= scanner.nextInt();
            LocalDate fechaNacimientoPaciente= LocalDate.of(ano,mes,dia); //objeto local date
            System.out.println("Ingresa el tipo de sangre del paciente ");
            String tipoSangre= scanner.nextLine();
            scanner.nextLine(); //ayuda a limpiar buffer por si hace saltos
            System.out.println("Ingresa el telefono del paciente ");
            String numeroTelefono = scanner.nextLine();
            scanner.nextLine();
            System.out.println("Ingresa el sexo del paciente ");
            String sexoString= scanner.nextLine();
            scanner.nextLine();
            char sexo= sexoString.charAt(0);
            Paciente paciente =new Paciente(id,nombre,apellido,fechaNacimientoPaciente,tipoSangre,numeroTelefono,sexo);
            hospital.registrarPaciente(paciente);
            System.out.println(" Paciente registrado correctamente ");
            break;
        case 2:
            System.out.println("\nSeleccionaste la opción para Registrar Medico ");
            System.out.println("Ingresa el nombre del Medico");
            String nombreMedico= scanner.nextLine();
            System.out.println("Ingresa el apellido del Medico");
            String apellidoMedicoString= scanner.nextLine();
            char apellidoMedico= apellidoMedicoString.charAt(0);
            char apellidoMedico1= apellidoMedicoString.charAt(1);
            System.out.println("Ingresa la fecha de nacimiento del Medico Ex:1993-04-02");
            System.out.println("Ingresa año ");
            int anoMedico= scanner.nextInt();
            System.out.println("Ingresa mes ");
            int mesMedico= scanner.nextInt();
            System.out.println("Ingresa dia ");
            int diaMedico= scanner.nextInt();
            LocalDate fechaNacimientoMedico1= LocalDate.of(anoMedico,mesMedico,diaMedico);
            System.out.println("Ingresa el numero de telefono del Medico");
            String numeroTelefonoMedico= scanner.nextLine();
            System.out.println("Ingresa el rfc del Medico");
            String rfcMedico= scanner.nextLine();
            String idMedico=hospital.generarIdMedico(apellidoMedico,apellidoMedico1,fechaNacimientoMedico1);
            System.out.println(idMedico);
            Medico medico =new Medico(idMedico,nombreMedico,apellidoMedicoString,fechaNacimientoMedico1,numeroTelefonoMedico,rfcMedico);
            hospital.registrarMedico(medico);

            break;
        case 3:
            System.out.println("\nSeleccionaste la opción para Registrar Consultorio ");
            System.out.println("Ingresa el piso en el que se encuentra el consultorio");
            int piso= scanner.nextInt();
            System.out.println("Ingresa el numero de consultorio");
            int numeroConsultorio= scanner.nextInt();
            String idConsultorio=hospital.generarIdConsultoio();
            System.out.println(idConsultorio);
            Consultorio consultorio=new Consultorio(idConsultorio,numeroConsultorio,piso);
            hospital.registrarConsultorio(consultorio);
            break;
        case 4:
            System.out.println("\nSeleccionaste la opción para Registrar Consulta ");
            int idConsulta=hospital.generarIdConsulta();
            LocalDateTime fechaConsulta=null;
            while (fechaConsulta==null){
                System.out.println("Ingresa dia de la consulta ");
                int diaConsulta= scanner.nextInt();
                System.out.println("Ingresa el mes de la consulta");
                int mesConsulta= scanner.nextInt();
                System.out.println("Ingresa el año de la consulta");
                int anoConsulta= scanner.nextInt();
                System.out.println("Ingresa la hora de la  consulta");
                int horaConsulta= scanner.nextInt();
                System.out.println("Ingresa los minutos de la  consulta");
                int minutosConsulta= scanner.nextInt();
                fechaConsulta =LocalDateTime.of(anoConsulta,mesConsulta,diaConsulta,horaConsulta,minutosConsulta);
                if (!hospital.validarFechaConsulta(fechaConsulta)){
                    System.out.println("La fecha no puede estar en el pasado");
                    fechaConsulta=null;
                }
            }
            scanner.nextLine();
            Paciente pacienteConsulta=null;
            while (pacienteConsulta==null){
                System.out.println("Ingresa el id del paciente ");
                String pacienteId= scanner.nextLine();
                pacienteConsulta=hospital.obtenerPacientePorId(pacienteId);
                if (pacienteConsulta==null){
                    System.out.println("El id del paciente no existe prueva de nuevo");
                }
            }
            scanner.nextLine();
            Medico medicoConsulta=null;
            while (medicoConsulta==null){
                System.out.println("Ingresa el id del medico ");
                String idMedico1= scanner.nextLine();
                medicoConsulta=hospital.obtenerMedicoPorId(idMedico1);
                if (medicoConsulta==null){
                    System.out.println("El id del medico no existe prueva de nuevo");
                }
            }
            Consultorio consultorioConsulta=null;
            while (consultorioConsulta==null){
                System.out.println("Ingresa el id del consultorio ");
                String idConsultorio1 = scanner.nextLine();
                consultorioConsulta = hospital.obtenerConsultorioPorId(idConsultorio1);
                if (consultorioConsulta==null){
                    System.out.println("El id del medico no existe prueva de nuevo");
                }
            }
            Consulta consulta= new Consulta(idConsulta,fechaConsulta,pacienteConsulta,medicoConsulta,consultorioConsulta);
            hospital.registrarConsulta(consulta);
            System.out.println(hospital.listaConsultas.get(0));
            break;
        case 5:
            System.out.println("\nSeleccionaste la opción para Mostrar Pacientes ");
            hospital.mostrarPacientes();
            break;
        case 6:
            System.out.println("\nSeleccionaste la opción para Mostrar Medicos");
            hospital.mostrarMedico();
            break;
        case 7:
            System.out.println("\nSeleccionaste la opción para Mostrar Consultorios");
            hospital.mostrarConsultorios();
            break;
        case 8:
            System.out.println("\nSeleccionaste la opción para Mostrar Consulta");
            hospital.mostrarConsultas();
            break;
        case 9:
            System.out.println("/nSeleccionaste la opcion de Mostrar Paciente por Id ingresalo");
            String idPaciente =scanner.nextLine();
            hospital.mostrarPacientePorId(idPaciente);
            break;
        case 10:
            System.out.println("/nSeleccionaste la opcion de Mostrar Medico por Id ingresalo");
            String idMedico2 =scanner.nextLine();
            hospital.mostrarMedicoPorId(idMedico2);
            break;
        case 11:
            System.out.println("/nSeleccionaste la opcion de Mostrar Consultorio por Id ingresalo");
            String idConsultorio2 =scanner.nextLine();
            hospital.mostrarConsultorioPorId(idConsultorio2);
            break;
        case 12:
            System.out.println("Hasta luego");
            return;

            }
        }
    }
}
