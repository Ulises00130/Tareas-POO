package menu;

import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import usuarios.Usuario;
import usuarios.administrador.Administrador;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import usuarios.utils.Rol;
import usuarios.utils.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private Hospital hospital=new Hospital();
    public Usuario usuarioEnSesion;


    public void login(){
        int intentosMaximos = 5, intentosUser=0;
        //Iniciar con el administrador como predeterminado
        //this.mostrarMenuAdmin(hospital.administrador);

        int opc;
        do {
            opc = mostrarMenu(hospital.administrador);
            // menuAdministrador.procesarDatosMenu(opc, hospital.administrador, hospital);
        }while (opc != 14);

        while(intentosUser < intentosMaximos){
            System.out.print("\n--------Bienvenido/a--------\n");
            System.out.println("---Inicia sesión para continuar---");

            scanner.nextLine();
            System.out.print("Ingrese su usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Ingrese su contraseña: ");
            String contrasena = scanner.nextLine();

            usuarioEnSesion = hospital.validarInicioSesion(usuario,contrasena);

            if (usuarioEnSesion instanceof Usuario){
                if (usuarioEnSesion.getRol() == Rol.PACIENTE){
                    Paciente pacienteEnSesion = (Paciente) usuarioEnSesion;

                    int opcion = mostrarMenuPaciente(pacienteEnSesion);

                    intentosUser=0;
                }else if (usuarioEnSesion.getRol() == Rol.MEDICO){
                    Medico medicoEnSesion = (Medico) usuarioEnSesion;


                    int opcion = mostrarMenuMedico(medicoEnSesion);

                    intentosUser=0;
                }else{
                    Administrador AdminEnSesion = (Administrador) usuarioEnSesion;

                    opc = mostrarMenu(hospital.administrador);

                    intentosUser=0;
                }
            }else{
                intentosUser= mostrarErrorInicioSesion(intentosUser);
            }
        }
        System.out.println("\nLímite de intentos alcanzado\n");
    }

    private int mostrarErrorInicioSesion(int intentosUser){
        System.out.print("\nUsuario o contraseña incorrecta, intente de nuevo\n");
        intentosUser++;
        return intentosUser;
    }
    ///***********MENU PACIENTE****************///
    public int mostrarMenuPaciente(Paciente paciente){
        int opcion =0;

        while (opcion!=4){
            System.out.println("\n**SISTEMA HOSPITAL**");
            System.out.println("1.-Ver mis consultas");
            System.out.println("2.-Ver mi informacion Personal");
            System.out.println("3.-Ver mi expedinte");
            System.out.println("4.-Salir");
            System.out.println("Selecciona una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    hospital.mostrarConsultasPacientes(paciente.getId());
                    break;
                case 2:
                    hospital.mostrarPacientePorId(paciente.getId());
                    break;
                case 3:
                    //ver mi expediente
                    break;
                case 4:
                    System.out.println("\n-----Adiosito-----");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            }
        }
        return opcion;
    }

    ///***********MENU MEDICO****************///
    public int mostrarMenuMedico(Medico medico){
        int opcion = 0;
        while (opcion != 7){
            System.out.println("\n**SISTEMA HOSPITAL**");
            System.out.println("1.-Ver mis consultas");
            System.out.println("2.-Ver mis pacientes");
            System.out.println("3.-Consultar paciente");
            System.out.println("4.-Consultar expediente de paciente");
            System.out.println("5.-Completar consulta");
            System.out.println("6.-Mostrar informacion personal");
            System.out.println("7.-Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    hospital.mostrarConsultasMedicos(medico.getId());
                    break;
                case 2:
                    hospital.mostrarPacientesDeMedico(medico.getId());
                    break;
                case 3:
                    // Implementar funcionalidad para consultar paciente
                    System.out.println("Ingrese el id del paciente: ");
                    String idPaciente = scanner.nextLine();
                    hospital.mostrarPacientePorId(idPaciente);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    hospital.mostrarMedicoPorId(medico.getId());
                    break;
                case 7:
                    System.out.println("\n-----Adiosito-----");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            }
        }
        return opcion;
    }




    ///***********MENU ADMINISTRADOR****************///
   /* public int mostrarMenuAdmin(Administrador administrador){
        mostrarMenu(hospital.administrador);
        int x=mostrarMenu(hospital.administrador);
        return  x;
    }*/

    public int mostrarMenu(Administrador administrador) {


        int opcion = 0;
        while (opcion != 14) {
            System.out.println("\n*** SISTEMA HOSPITAL***");
            System.out.println("Bienvenido " + administrador.nombre);
            System.out.println("1.Registrar Paciente ");//punto no1 con su mostrar
            System.out.println("2.Registrar Medico ");//punto no2 son su mostrar esta
            System.out.println("3.Registrar Consultorio ");
            System.out.println("4.Registrar Consulta ");//punto no 3 con su mostrar
            System.out.println("5.Mostrar Pacientes ");
            System.out.println("6.Mostrar Medicos");
            System.out.println("7.Mostrar Consultorios");
            System.out.println("8. Mostrar consultas");
            System.out.println("9. Mostrar Paciente por Id");
            System.out.println("10.Mostrar Medico por Id");
            System.out.println("11.Mostrar Consultorio por Id");
            System.out.println("12. Ver mi informacion");
            System.out.println("13. Mostrar Lista Usuarios");
            System.out.println("14. Salir");
            System.out.println("Selecciona una opción: ");
            opcion = scanner.nextInt();


            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nSeleccionaste la opción para Registrar Paciente");

                    ArrayList<String> datosPaciente = this.obtenerDatosComun(Rol.PACIENTE,hospital);

                    String id=hospital.generarIdPaciente();
                    System.out.println(id);

                    System.out.println("Ingresa el tipo de sangre del paciente ");
                    String tipoSangre= scanner.nextLine();

                    scanner.nextLine(); //ayuda a limpiar buffer por si hace saltos


                    System.out.println("Ingresa el sexo del paciente ");
                    String sexoString= scanner.nextLine();
                    scanner.nextLine();
                    char sexo= sexoString.charAt(0);

                    Paciente paciente =new Paciente(id, datosPaciente.get(0), datosPaciente.get(1),  LocalDate.parse(datosPaciente.get(2)), datosPaciente.get(4), tipoSangre,sexo, datosPaciente.get(3), datosPaciente.get(5));
                    hospital.registrarPaciente(paciente);
                    System.out.println(" Paciente registrado correctamente ");
                    break;
                case 2:
                    System.out.println("\nSeleccionaste la opción para Registrar Medico ");
                    ArrayList<String> datosMedico = this.obtenerDatosComun(Rol.MEDICO,hospital);//TAREA 04
                    String x=datosMedico.get(1);
                    char apellidoMedico= x.charAt(0);
                    char apellidoMedico1= x.charAt(1);
                    LocalDate fechaNacimientoMedico1=LocalDate.parse(datosMedico.get(2));

                    String rfcMedico = null;
                    boolean rfcx = false;
                    while (!rfcx) {
                        System.out.println("Ingresa el rfc del Medico");
                        rfcMedico= scanner.nextLine();
                        rfcx = true;
                        for (Medico medicoExistente : hospital.listaMedicos) {
                            if (medicoExistente.getRfc().equals(rfcMedico)) {
                                System.out.println("Tenemos un Medico con ese RFC intentelo de nuevo");
                                rfcx = false;
                                break;
                            }
                        }
                    }


                    String idMedico=hospital.generarIdMedico(apellidoMedico,apellidoMedico1,fechaNacimientoMedico1);
                    System.out.println(idMedico);

                    Medico medico =new Medico(idMedico,datosMedico.get(0),datosMedico.get(1),LocalDate.parse(datosMedico.get(2)), datosMedico.get(4), rfcMedico, datosMedico.get(3),datosMedico.get(5));
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

                    Consulta consulta= new Consulta(idConsulta,fechaConsulta,pacienteConsulta,medicoConsulta,consultorioConsulta, Status.PENDIENTE);
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
                    System.out.println("Mis Datos");
                    hospital.mostrarAdministradorPorId(administrador.id);
                    break;
                case 13:
                    hospital.mostrarListaUsuarios();
                    break;
                case 14:
                    System.out.println("Hasta luego");
                    break;
            }

        }
        return  opcion;
    }

    private ArrayList<String> obtenerDatosComun(Rol rol,Hospital hospital ){
        String tipoUsuario = rol == Rol.PACIENTE ? "Paciente" : rol == Rol.MEDICO ? "Medico" : "Administrador";

        ArrayList<String> datos = new ArrayList<>();

        // 0
        System.out.print("Ingrese el/los nombre(s) del "+tipoUsuario+": ");
        String nombre = scanner.nextLine();
        datos.add(nombre);

        // 1
        System.out.print("Ingrese los apellido(s) "+tipoUsuario+": ");
        String apellido = scanner.nextLine();
        datos.add(apellido);

        String fechaNacimiento=obtnerFechaNacimientoUsuario(tipoUsuario);
        datos.add(fechaNacimiento);

        // 3
        System.out.print("Ingrese la contraseña "+tipoUsuario+": ");
        String contrasena = scanner.nextLine();
        datos.add(contrasena);

        // 4

        boolean esTelefonoValido=false;
        String telefono="";
        while (!esTelefonoValido){
            System.out.print("Ingrese el telefono "+tipoUsuario+": ");
            telefono = scanner.nextLine();
            esTelefonoValido=hospital.validarTelefonoRepetido(rol==Rol.PACIENTE ? hospital.listaPacientes:hospital.listaMedicos,telefono);
        }
        datos.add(telefono);
        //5
        boolean esEmailValido=false;
        String email="";
        while (!esEmailValido){
            System.out.print("Ingrese el email "+tipoUsuario+": ");
            email = scanner.nextLine();
            esEmailValido=hospital.validarEmailRepetido(rol==Rol.PACIENTE ? hospital.listaPacientes:hospital.listaMedicos,email);
        }
        datos.add(email);

        return datos;
    }


    public String obtnerFechaNacimientoUsuario(String tipoUsuario){
        LocalDate fechaNacimiento =null;
        boolean esFechaValida=false;
        while (!esFechaValida){

            System.out.print("Ingrese el año de nacimiento "+tipoUsuario+": ");
            int ano = scanner.nextInt();

            System.out.print("Ingrese el mes de nacimiento "+tipoUsuario+": ");
            int mes = scanner.nextInt();

            System.out.print("Ingrese el dia de nacimiento "+tipoUsuario+": ");
            int dia = scanner.nextInt();
            scanner.nextLine();

            // 2
            fechaNacimiento = LocalDate.of(ano, mes, dia);


            if(fechaNacimiento.isAfter(LocalDate.now())) {
                System.out.print("La fecha de nacimiento no puede ser posterioir de hoy ");
            }else{

                esFechaValida=true;

            }
        }
        return fechaNacimiento.toString();
    }

}


