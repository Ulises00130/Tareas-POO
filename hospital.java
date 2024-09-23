package hospital;

import consulta.Consulta;
import consultorio.Consultorio;
import medico.Medico;
import pacientes.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Hospital {
    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medico> listaMedicos = new ArrayList<>();
    public ArrayList<Consulta> listaConsultas = new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    private ValidadorHospital validador =new ValidadorHospital(); //otro atributo pero es un objeto
    public void registrarPaciente(Paciente paciente){
        this.listaPacientes.add(paciente);
    }
    public void registrarMedico(Medico medico){
        this.listaMedicos.add(medico);
    }

    public void registrarConsulta(Consulta consulta){
        //No exista una consulta en la fecha deseada
        if (!validador.validarDisponibilidadEnFechaConsulta(consulta.getFechaHora(), consulta.getConsultorio().getNumeroConsultorio(),this.listaConsultas)) {
            System.out.println("Ya existe una consulta registraddad para esa fecha");
            return;
        }

        if (validador.validarDisponibilidadMedico(consulta.getFechaHora(),consulta.getMedico().getId(),this.listaConsultas)){
            System.out.println("El medico no tiene disponibilidad para esa fecha ");
            return;
        }
        //this.listaConsultas.add(consulta);
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
    public void mostrarMedicos(){
        System.out.println("\n Medicos del hospital");
        for(Medico medico : this.listaMedicos){
            System.out.println(medico.mostrarDatos());
        }

    }

    public String generarIdMedico() {
        Random random = new Random();
        LocalDate fecha= LocalDate.now();
        int anoActual=fecha.getYear();
        int mesActual= fecha.getMonthValue();
        int longitudMedicoMasUno=this.listaMedicos.size();
        int numeroAleatorio= random.nextInt(50,700000);
        String id=String.format("M%d%d%d%d",anoActual,mesActual,longitudMedicoMasUno,numeroAleatorio);
        return id;
    }

    public void mostrarConsltorio(){
        System.out.println("\n Consultorio del hospital");
        for(Consultorio consultorio : this.listaConsultorios){
            System.out.println(consultorio.mostrarDatos());
        }

    }

    public String generarIdConsultorio() {
        Random random = new Random();
        LocalDate fecha= LocalDate.now();
        int anoActual=fecha.getYear();
        int longitudConsultoriosMasUno=this.listaConsultorios.size();
        int numeroAleatorio= random.nextInt(1,500000);
        String id=String.format("C%d%d%d%d",anoActual,longitudConsultoriosMasUno,numeroAleatorio);
        return id;
    }
}

