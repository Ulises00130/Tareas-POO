package cine;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Horarios {
    private LocalDateTime horario;
    private String salaId;
    private String peliculaId;


    public Horarios(LocalDateTime horario, String salaId, String peliculaId) {
        this.horario = horario;
        this.salaId = salaId;
        this.peliculaId = peliculaId;
    }


    public String getHorario() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return horario.format(formatter);
    }

    public LocalDateTime getHorarioDateTime() {
        return horario;
    }

    public String getSalaId() {
        return salaId;
    }

    public String getPeliculaId() {
        return peliculaId;
    }


    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }


    public void setSalaId(String salaId) {
        this.salaId = salaId;
    }


    public void setPeliculaId(String peliculaId) {
        this.peliculaId = peliculaId;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return "Horario: " + horario.format(formatter) + " | Sala: " + salaId + " | Película: " + peliculaId;
    }
}
