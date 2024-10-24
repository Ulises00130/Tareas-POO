package hospital;

import consultas.Consulta;
import consultorios.Consultorio;
import expedientes.Expediente;
import usuarios.Usuario;
import usuarios.administrador.Administrador;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import usuarios.utils.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hospital {
    public ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    public ArrayList<Administrador> listaAdministradores = new ArrayList<>();

    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medico> listaMedicos = new ArrayList<>();
    public ArrayList<Consulta> listaConsultas = new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    private ValidadorHospital validador =new ValidadorHospital(); //otro atributo pero es un objeto

    public Scanner scanner = new Scanner(System.in);
    public Expediente expediente;
    public Administrador administrador;

    //DATOS FECHA ADMIN
    public LocalDate fechaNacimientoAdmin = LocalDate.of(2004, 11, 23);

    public Hospital(){
        administrador = new Administrador("A-1","Nico","Guzman", fechaNacimientoAdmin,"443","GUD","12345",11000008, 5,"nicolas@gmail.com");
        this.listaUsuarios.add(administrador);
        this.listaAdministradores.add(administrador);
    }
    //

    public void registrarPaciente(Paciente paciente){
        this.listaPacientes.add(paciente);
        this.listaUsuarios.add(paciente);
    }
    public void registrarMedico(Medico medico){
        this.listaMedicos.add(medico);
        this.listaUsuarios.add(medico);
    }

    public void registrarConsulta(Consulta consulta){
        //No exista una consulta en la fecha deseada
        if (!validador.validarDisponibilidadEnFechaConsulta(consulta.getFechaHora().toLocalDate(), consulta.getConsultorio().getNumeroConsultorio(),this.listaConsultas)) {
            System.out.println("Ya existe una consulta registradad para esa fecha");
            return;
        }

        if (!validador.validarDisponibilidadMedico(consulta.getFechaHora(),consulta.getMedico().getId(),this.listaConsultas)){
            System.out.println("El medico no tiene disponibilidad para esa fecha ");
            return;
        }
        this.listaConsultas.add(consulta);
        System.out.println("Consulta registrada correctamente ");
    }

    public void registrarConsultorio(Consultorio consultorio){
        this.listaConsultorios.add(consultorio);
    }


    /*SEGUN YO FALTA ESTE
     public void registrarConsulta(Consulta consulta){
        Consulta consulta=new Consulta(1,"2024-08-10",Pac1,Med1,Cons1);
        //Paciente no tenga consulta en esa fecha

    /*
    1.-No existe una consulta en la fecha indicada en el consltorio indicado
    2.-Fecha Valida
    3.-Medico no tenga una consulta en esa fecha en otro consultorio
    4.-Paciente no tenga consulta en esa fecha

        this.listaConsultas.add(consulta);

    }
   SEGUN YO FALTA */

    public void mostrarPacientes(){
        System.out.println("\n Pacientes del hospital");
        for(Paciente paciente : this.listaPacientes){
            System.out.println(paciente.mostrarDatos());
        }

    }

    public String generarIdPaciente() {
        Random random = new Random();
        LocalDate fecha= LocalDate.now();
        int anoActual=fecha.getYear();
        int mesActual= fecha.getMonthValue();
        int longitudPacientesMasUno=this.listaPacientes.size();
        int numeroAleatorio= random.nextInt(1,1000);
        String id=String.format("P%d%d%d%d",anoActual,mesActual,longitudPacientesMasUno,numeroAleatorio);
        return id;
    }
    public void mostrarPacientePorId(String id) {
        //OTRA FORMA DE ESCRIBIR EL CODIGO DE ABAJO DE MANERA DIFERENTE
        //Optional<Paciente> pacienteEncontrado=this.listaPacientes.stream().filter(paciente -> paciente.getId().equals(id)).findFirt();
        // if (pacienteEncontrado.isPresent()){System.out.println(pacienteEncontrado.get().mostrarDatos());
        // }else{System.out.println("No se encontro al paciente"); }

        for(Paciente paciente:this.listaPacientes){
            if(paciente.getId().equals(id)){
                System.out.println(paciente.mostrarDatos());
                return;
            }
        }
        System.out.println("Paciente no encontrado");
    }

    public Paciente obtenerPacientePorId(String id) {
        return listaPacientes.stream().filter(paciente -> paciente.getId().equals(id)).findFirst().orElse(null);
    }


    public String generarIdMedico(char apellidoMedico,char apellidoMedico1,LocalDate fechadeNacimiento1) {
        Random random = new Random();
        LocalDate fecha= LocalDate.now();
        int anoActual=fecha.getYear();

        int longitudMedicosmasUno=this.listaMedicos.size()+1;  //No me salio este rev luego
        int numeroAleatorio= random.nextInt(1,9);

        int anoNacimiento = fechadeNacimiento1.getYear();
        int mesNacimiento = fechadeNacimiento1.getMonthValue();
        int diaNacimiento = fechadeNacimiento1.getDayOfMonth();

        String idMedico=String.format("%c%c%d%d%d%d",apellidoMedico,apellidoMedico1,anoNacimiento,mesNacimiento,diaNacimiento,numeroAleatorio,longitudMedicosmasUno);
        // M=cadena , c=char ,d=int,
        return idMedico;
    }

    public String generarIdConsultoio() {
        Random random = new Random();
        LocalDate fecha= LocalDate.now();
        int anoActual=fecha.getYear();
        int diaActual=fecha.getDayOfMonth();
        int longitudConsultoriomasUno=this.listaConsultorios.size()+1;  //No me salio este rev luego
        int numeroAleatorio= random.nextInt(1,9);
        String idConsultorio=String.format("%d%d%d%d",longitudConsultoriomasUno,diaActual,anoActual,numeroAleatorio);
        // M=cadena , c=char ,d=int,
        return idConsultorio;
    }

    public void mostrarMedico(){
        System.out.println("\n Medicos del hospital");
        for(Medico medico : this.listaMedicos){
            System.out.println(medico.mostrarDatosM());
        }

    }
    public void mostrarConsultorios(){
        System.out.println("\n Consultorios del hospital");
        for(Consultorio consultorio : this.listaConsultorios){
            System.out.println(consultorio.mostrarDatosConsultorio());
        }


    }

    public void mostrarMedicoPorId(String idMedico2) {
        for (Medico medico : this.listaMedicos) {
            if (medico.getId().equals(idMedico2)) {
                System.out.println(medico.mostrarDatosM());
                return;
            }
        }
        System.out.println("Medico no encontrado");
    }

    public Medico obtenerMedicoPorId(String idMedico1) {
        return listaMedicos.stream().filter(medico -> medico.getId().equals(idMedico1)).findFirst().orElse(null);
    }



    public void mostrarConsultorioPorId(String idConsultorio) {
        for (Consultorio consultorio : this.listaConsultorios) {
            if (consultorio.getId().equals(idConsultorio)) {
                System.out.println(consultorio.mostrarDatosConsultorio());
                return;
            }
        }
        System.out.println("Consultorio no encontrado");
    }


    public Consultorio obtenerConsultorioPorId(String idConsultorio1) {
        return listaConsultorios.stream().filter(consultorio -> consultorio.getId().equals(idConsultorio1)).findFirst().orElse(null);
    }

    public int generarIdConsulta() {
        Random random = new Random();
        LocalDate fecha= LocalDate.now();
        int anoActual=fecha.getYear();
        int diaActual=fecha.getDayOfMonth();

        int numeroAleatorio= random.nextInt(1,100000);
        int idConsulta = Integer.parseInt(String.format("%d%d%d", diaActual, anoActual, numeroAleatorio));
        // M=cadena , c=char ,d=int,
        return idConsulta;
    }

    public boolean validarFechaConsulta(LocalDateTime fechaDeseada){
        return this.validador.validarFechaCorrecta(fechaDeseada);
    }

    public void mostrarConsultas(){
        if(this.listaConsultas.isEmpty()){
            System.out.print("/nNo se cuenta con consultas registradas");
        }
        System.out.print("Lista de consultas");

        for(Consulta consulta : this.listaConsultas){
            consulta.mostrarInformacion();
        }
    }

    /*public boolean revisionNumeros(String numeroTelefono){
        if (this.listaPacientes.isEmpty()) {
            return true;
        }
        for(Paciente paciente:this.listaPacientes){

            if (paciente.getTelefono().equals(numeroTelefono)) {
                return false; // si son los mismos
            }
        }
        return true;
    }*/
    /*public boolean telefonoExiste(String numeroTelefono) {
        for (Paciente paciente : this.listaPacientes) {
            if (paciente.getTelefono().equals(numeroTelefono)) {
                return true; // Ya existe un paciente con ese teléfono
            }
        }
        return false; // El teléfono no existe

    }*/
    public Usuario validarInicioSesion(String idUser, String contrasena){
        for (Usuario usuario : this.listaUsuarios) {
            if (usuario.getId().equals(idUser) && usuario.getContrasenia().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

    ///AGG
    public void eliminarConsultaPorId(int idConsulta){
        for (Consulta consulta : this.listaConsultas) {
            if (consulta.getId()==idConsulta) {
                this.listaConsultas.remove(consulta);
                return;
            }
        }
    }
    public void mostrarAdministradorPorId(String id){
        Administrador administrador1 = obtenerAdministradorPorId(id);
        if (administrador1 != null) {
            System.out.println(administrador1.mostrarDatos());
        } else {
            System.out.println("No se encontró el paciente con el ID " + id);
        }
    }

    public void mostrarConsultasMedicos(String id) {
        List<Consulta> consultasMedico = this.listaConsultas.stream()
                .filter(consulta -> consulta.getMedico().getId().equals(id))
                .toList();

        if (consultasMedico.isEmpty()) {
            System.out.println("\nNo tiene consultas registradas.");
        } else {
            System.out.println("\n*** Consultas del Médico ***");
            for (Consulta consulta : consultasMedico) {
                consulta.mostrarInformacion();               ///POSIBLE ERROR
            }
        }
    }

    public void mostrarPacientesDeMedico(String id) {
        List<Paciente> pacientesMedico = this.listaConsultas.stream()
                .filter(consulta -> consulta.getMedico().getId().equals(id))
                .map(Consulta::getPaciente)
                .distinct()
                .toList();

        if (pacientesMedico.isEmpty()) {
            System.out.println("\nNo tiene usuarios.pacientes registrados.");
        } else {
            System.out.println("\n*** PACIENTES DEL MÉDICO ***");
            for (Paciente paciente : pacientesMedico) {
                System.out.println(paciente.mostrarDatos());
            }
        }
    }

    public void mostrarConsultasPacientes(String id) {
        List<Consulta> consultasPaciente = this.listaConsultas.stream()
                .filter(consulta -> consulta.getPaciente().getId().equals(id))
                .toList();

        if (consultasPaciente.isEmpty()) {
            System.out.println("\nNo tiene consultas registradas.");
        } else {
            System.out.println("\n*** Consultas del Paciente ***");
            boolean existenConsultasPendientes = false;
            for (Consulta consulta : consultasPaciente) {
                consulta.mostrarInformacion();                   ///POSIBLE ERRROR
                if (consulta.getStatus()== Status.PENDIENTE) {
                    existenConsultasPendientes = true;
                }
            }
            if (!existenConsultasPendientes) {
                System.out.println("No tienes consultas pendientes.");
            }
        }
    }

    public Administrador obtenerAdministradorPorId(String idP){
        return this.listaAdministradores.stream().filter(
                administrador -> administrador.getId().equals(idP)
        ).findFirst().orElse(null);
    }


    public Consulta obtenerConsultaPorid(String idConsulta){
        for (Consulta consulta : this.listaConsultas) {
            if (consulta.getPaciente().getId().equals(idConsulta)) {
                return consulta;
            }
        }
        return null;
    }
    public boolean validarNumeroTelefonoPaciente(String numeroTelefono) {
        for (Paciente paciente : listaPacientes) {
            if (paciente.getTelefono().equals(numeroTelefono)) {
                return false;
            }
        }
        return true;
    }

    public boolean validarNumTelefonoMedico(String numeroTelefono) {
        for (Medico medico : listaMedicos) {
            if (medico.getTelefono().equals(numeroTelefono)) {
                return false;
            }
        }
        return true;
    }

    public boolean validarRFCMedico(String rfc) {
        for (Medico medico : listaMedicos) {
            if (medico.getRfc().equals(rfc)) {
                return false;
            }
        }
        return true;
    }

    public boolean validarConsulta(LocalDateTime fechaHora, int numeroConsultorio, String idMedico) {
        boolean disponibleConsultorio = validador.validarDisponibilidadEnFechaConsulta(fechaHora.toLocalDate(), numeroConsultorio, this.listaConsultas);
        boolean disponibleMedico = validador.validarDisponibilidadMedico(fechaHora, idMedico, this.listaConsultas);

        return disponibleConsultorio && disponibleMedico;
    }

    public void generarExpedienteConsulta(String idConsulta, String idPaciente){
        Consulta consulta = this.obtenerConsultaPorid(idConsulta);
        Paciente paciente = this.obtenerPacientePorId(idPaciente);

        if (consulta == null) {
            System.out.println("No existe una consulta con el id proporcionado");
            return;
        }


        if (paciente == null) {
            System.out.println("No existe una consulta con el id proporcionado");
            return;
        }

        consulta.setStatus(Status.TERMINADA);

        //Eliminar consulta de lista de consultas
        this.eliminarConsultaPorId(Integer.parseInt(idConsulta));


        System.out.println("Ingresa las observaciones finales de la consulta: ");
        String observaciones = scanner.nextLine();

        expediente = new Expediente(consulta, observaciones);

        //Registrar expediente al paciente
        paciente.registrarExpediente(expediente);
        System.out.println("Consulta finalizada");
    }


    public void mostrarListaUsuarios() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }

        for (Usuario usuario : listaUsuarios) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nombre: " + usuario.getNombre() + " " + usuario.getApellidos());
            System.out.println("Fecha de Nacimiento: " + usuario.getFechaNacimiento());
            System.out.println("Teléfono: " + usuario.getTelefono());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Rol: " + usuario.getRol());
            System.out.println("-----------------------------");
        }
    }
    public boolean validarTelefonoRepetido(ArrayList<? extends Usuario>listaUsuarios,String telefono){
        for (Usuario usuario : listaUsuarios) {
            if(usuario.getTelefono().equals(telefono)){
                System.out.print("Ya existe un usuario con ese telefono intenta de nuevo");
                return false;
            }
        }
        return true;
    }

    public boolean validarEmailRepetido(ArrayList<? extends Usuario>listaUsuarios,String email){
        for (Usuario usuario : listaUsuarios) {
            if(usuario.getEmail().equals(email)){
                System.out.print("Ya existe un usuario con ese email intenta de nuevo");
                return false;
            }
        }
        return true;
    }
}

