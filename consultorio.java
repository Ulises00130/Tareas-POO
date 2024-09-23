package consultorio;

public class Consultorio {
    public int id;
    public int piso;
    public int numeroConsultorio;

    public Consultorio(int id, int piso, int numeroConsultorio) {
        this.id = id;
        this.piso = piso;
        this.numeroConsultorio = numeroConsultorio;
    }

    public int getId() {
        return id;
    }

    public int getPiso() {
        return piso;
    }

    public int getNumeroConsultorio() {
        return numeroConsultorio;
    }
    public String mostrarDatos(){
        String datos= String.format("/n id=%s,piso:%s,numeroConsultorio:%s", id, piso, numeroConsultorio);

        return datos;
    }
}