package hospital;

import consultas.Consulta;
import consultas.utils.Status;
import consultorios.Consultorio;
import usuarios.administrador.Administrador;
import usuarios.Usuario;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;


public class Hospital {
    public ArrayList <Usuario> listaUsuarios = new ArrayList();
    public ArrayList <Administrador> listaAdministradores = new ArrayList();
    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medico> listaMedicos = new ArrayList<>();
    public ArrayList<Consulta> listaConsultas = new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    private ValidadorHospital validador =new ValidadorHospital();
    public Hospital(){
        //LocalDateTime fechahoy
        //Administrador = new Administrador("wdwd","d","apellido",fecha,"4343","ssss", Rol.ADMIN, 1323,20,"PEVEV");
        //this.listaUsuarios.add(Administrador);
        //this.listaAdministradores.add(Administrador);
    }
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
        if (!validador.validarDisponibilidadEnFechaConsulta(consulta.getFechaHora(), consulta.getConsultorio().getNumeroConsultorio(),this.listaConsultas)) {
            System.out.println("Ya existe una consulta registrada para esa fecha");
            return;
        }

        if (!validador.validarDisponibilidadMedico(consulta.getFechaHora(),consulta.getMedico().getId(),this.listaConsultas)){
            System.out.println("El medico no tiene disponibilidad para esa fecha ");
            return;
        }
        this.listaConsultas.add(consulta);
    }
    public void registrarConsultorio(Consultorio consultorio){
        this.listaConsultorios.add(consultorio);
    }


    public void mostrarPacientes(){
        System.out.println("\n Pacientes del hospital");
        for(Paciente paciente : this.listaPacientes){
            System.out.println(paciente.mostrarDatos());
        }
    }
    public void mostrarMedicos(){
        System.out.println("\n Medicos del hospital");
        for(Medico medico : this.listaMedicos){
            System.out.println(medico.mostrarDatosM());
        }
    }
    public void mostrarConsultorios(){
        System.out.println("\n Consultorios del hospital");
        for(Consultorio consultorio : this.listaConsultorios){
            System.out.println(consultorio.mostrarDatos());
        }
    }

    public String generarIdPaciente() {
        Random random = new Random();
        LocalDate fecha= LocalDate.now();
        int anoActual=fecha.getYear();
        int mesActual= fecha.getMonthValue();
        int longitudPacientesMasUno=this.listaPacientes.size();
        int numeroAleatorio= random.nextInt(100000);
        String id=String.format("P%d%d%d%d",anoActual,mesActual,longitudPacientesMasUno,numeroAleatorio);
        return id;
    }

    public Paciente obtenerPacientePorId(String idPaciente){
        return listaPacientes.stream().filter(paciente -> paciente.getId().equals(idPaciente)).findFirst().orElse(null);
    }

    public Medico obtenerMedicoPorId(String idMedico){
        return listaMedicos.stream().filter(medico -> medico.getId().equals(idMedico)).findFirst().orElse(null);
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
    public void mostrarMedicoPorId(String id){
        for(Medico medico:this.listaMedicos){
            if(medico.getId().equals(id)){
                System.out.println(medico.mostrarDatosM());
                return;
            }
        }
    }
    public void mostrarConsultorioPorId(String id){
        for(Consultorio consultorio:this.listaConsultorios){
            if(consultorio.getId().equals(id)){
                System.out.println(consultorio.mostrarDatos());
                return;
            }
        }
    }

    public String generarIdConsultorio (){
        Random random = new Random();
        int longitudConsultorioMasUno =this.listaConsultorios.size();
        LocalDate fecha= LocalDate.now();
        int diaActual = fecha.getDayOfMonth();
        int anoActual= fecha.getYear();
        int numeroAleatorio= random.nextInt(500000);

        String idConsultorio = String.format("C%d%d%d%d",longitudConsultorioMasUno,diaActual,anoActual,numeroAleatorio);
        return idConsultorio;
    }

    public String generarIdMedico(String apellido, String anoNacimiento) {
        Random random = new Random();
        LocalDate fechaActual = LocalDate.now();
        int anoActual = fechaActual.getYear();
        int numeroAleatorio = 50 + random.nextInt(700000 - 50);
        int longitudMedicosMasUno = listaMedicos.size() + 1;
        String primerasLetrasApellido;
        if (apellido.length() >= 2) {
            primerasLetrasApellido = apellido.substring(0, 2).toUpperCase();
        } else {
            primerasLetrasApellido = apellido.toUpperCase();
        }
        String ultimoDigitoAnoNacimiento = anoNacimiento.substring(anoNacimiento.length() - 1);
        return String.format("M%s%s%d%d%d",
                primerasLetrasApellido,
                ultimoDigitoAnoNacimiento,
                anoActual,
                numeroAleatorio,
                longitudMedicosMasUno);
    }

    public boolean validarConsulta(LocalDateTime fechaConsulta, int numeroConsultorio, String idMedico) {
        boolean disponibleConsultorio = validador.validarDisponibilidadEnFechaConsulta(fechaConsulta, numeroConsultorio, this.listaConsultas);
        boolean disponibleMedico = validador.validarDisponibilidadMedico(fechaConsulta, idMedico, this.listaConsultas);

        return disponibleConsultorio && disponibleMedico;
    }
    public boolean validarFechaConsulta(LocalDateTime fechaDeseada) {
        return this.validador.validarFechaCorrecta(fechaDeseada);
    }

    public void mostrarConsultas (){
        if (this.listaConsultas.isEmpty()){
            System.out.println("\nNo se cuenta con consultas registradas");
            return;
        }
        System.out.println("---Lista de consultas---");
        for (Consulta consulta : this.listaConsultas) {
            System.out.println(consulta.mostrarInformacion());
        }
    }

    public Usuario validarInicioSesion(String idUsuario, String contrasenia ){
        for (Usuario usuario : this.listaUsuarios) {
            if (usuario.getId().equals(idUsuario)&& usuario.getContrasenia().equals(contrasenia)) {
                return usuario;
            }
        }
        return null;
    }
    public void verConsultasPaciente(String idPaciente){
        boolean existenConsultas = false;
        for (Consulta consulta : this.listaConsultas) {
            if(idPaciente.equals(consulta.getPaciente().getId()) && consulta.getStatus() == Status.PENDIENTE){
                existenConsultas = true;
                //Mostrar las consultas
                System.out.println(consulta.mostrarInformacion());
            }
        }
        if(!existenConsultas){
            System.out.println("No tienes consultas agendadas");
        }
    }

    public ArrayList<Consulta> verConsultasPorMedico(String idMedico) {
        ArrayList<Consulta> consultasMedico = new ArrayList<Consulta>();
        for (Consulta consulta : listaConsultas) {
            if (consulta.getMedico().getId().equals(idMedico)) {
                consultasMedico.add(consulta);
            }
        }
        return consultasMedico;
    }

}


