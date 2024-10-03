import pacientes.Paciente;

import java.time.LocalDateTime;

public class Consulta {
    public String idConsulta;
    public LocalDateTime fechaHora;
    public Paciente paciente;
    public Medico medico;
    public Consultorio consultorio;

    public Consulta(int idConsulta, LocalDateTime fechaHora, Paciente paciente, Medico medico, Consultorio consultorio) {
        this.idConsulta= String.valueOf(idConsulta);
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
    }


    public String getIdConsulta() {
        return idConsulta;
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


}

