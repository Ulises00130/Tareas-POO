package consultas;

import consultorios.Consultorio;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import usuarios.utils.Status;

import java.time.LocalDateTime;

public class Consulta {
    public int id;
    public LocalDateTime fechaHora;
    public Paciente paciente;
    public Medico medico;
    public Consultorio consultorio;
    public Status status;

    public Consulta(int id, LocalDateTime fechaHora, Paciente paciente, Medico medico, Consultorio consultorio, Status status) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
   /*public String mostrarInformacion12(){
        String info=String.format("Id:%d,fecha:%s,Id paciente:%s,nombre paciente:%s,id medico:%s,piso consultorio:%d,numero consultorio:%d",
                id,fechaHora.toString(),paciente.getId(),paciente.getNombre(),medico.getId(),medico.getNombre(),consultorio.getPiso(),consultorio.getNumeroConsultorio());
        return info;
    }*/

    public void mostrarInformacion() {
        System.out.println("Id: " + id +
                ", fecha: " + fechaHora +
                ", Id paciente: " + paciente.getId() +
                ", nombre paciente: " + paciente.getNombre() +
                ", id medico: " + medico.getId() +
                ", nombre medico: " + medico.getNombre() +
                ", piso consultorio: " + consultorio.getPiso() +
                ", Status: " + status+
                ", numero consultorio: " + consultorio.getNumeroConsultorio());
    }
}