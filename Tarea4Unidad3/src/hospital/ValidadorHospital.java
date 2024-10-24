package hospital;

import consultas.Consulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ValidadorHospital {


    public boolean validarDisponibilidadEnFechaConsulta(LocalDate fechaDeseada, int numeroConsultorio, ArrayList<Consulta> listaConsultas) {
        for (Consulta consulta : listaConsultas) {
            //if(consulta.getFechaHora().isEqual(fechaDeseada) &&  numeroConsultorio = consulta.getConsultorio()){
            //   return false;
            //}
            if (consulta.getFechaHora().toLocalDate().isEqual(fechaDeseada) &&
                    numeroConsultorio == consulta.getConsultorio().getNumeroConsultorio()) {
                return false; // Ya hay una consulta en la misma fecha y consultorio
            }
        }//to local
        return true;
    }

    public boolean validarDisponibilidadMedico(LocalDateTime fechaDeseada, String idMedico, ArrayList<Consulta> listaConsultas){
        for(Consulta consulta : listaConsultas){
            if(consulta.getFechaHora().isEqual(fechaDeseada) &&  consulta.getMedico().getId().equals(idMedico)){
                return false;

                // if (consulta.getFechaHora().equals(fechaDeseada)&& numeroConsultorio == consulta.getConsultorio().getNumeroConsultorio()) {
            }
        }
        return true;
    }


    public boolean validarFechaCorrecta(LocalDateTime fechaDeseada){
        LocalDateTime fechaActual = LocalDateTime.now();
        if(fechaDeseada.isBefore(fechaActual)){
            return false;
        }
        return true;
    }
}

