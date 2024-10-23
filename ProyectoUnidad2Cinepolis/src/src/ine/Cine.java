package cine;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import peliculas.Pelicula;
import salas.Sala;
import usuarios.Usuario;
import usuarios.administrador.Administrador;
import usuarios.clientes.Cliente;

public class Cine {
private Scanner scanner = new Scanner(System.in);
public ArrayList <Cliente> listaClientes = new ArrayList<>();
public ArrayList <Pelicula> listaPeliculas = new ArrayList <>();
public ArrayList <Sala> listaSalas = new ArrayList<>();
public ArrayList <Administrador> listaAdministradores=new ArrayList<>();
public ArrayList <Usuario> listaUsuarios = new ArrayList<>();
public ArrayList <Horarios> listaHorarios = new ArrayList<>();

//private Cliente cliente = new Cliente(null, null, null, null, null, null)


 public String generarIdCliente() {
        Random random = new Random();
        LocalDate fecha= LocalDate.now();
        int anoActual=fecha.getYear();
        int mesActual= fecha.getMonthValue();
        int longitudPacientesMasUno=this.listaClientes.size();
        int numeroAleatorio= random.nextInt(10000);
        String id=String.format("C%d%d%d%d",anoActual,mesActual,longitudPacientesMasUno,numeroAleatorio);
        return id;
    }

    public String generarIdHorario (){
        Random random = new Random();
        LocalDate fecha= LocalDate.now();
        int anoActual=fecha.getYear();
        int mesActual= fecha.getMonthValue();
        int longitudHorariosMasUno=this.listaHorarios.size();
        int numeroAleatorio= random.nextInt(10000);
        String id=String.format("H%d%d%d%d",anoActual,mesActual,longitudHorariosMasUno,numeroAleatorio);
        return id;
    }

    public String generarIdPelicula() {
        Random random = new Random();
        LocalDate fecha= LocalDate.now();
        int anoActual=fecha.getYear();
        int mesActual= fecha.getMonthValue();
        int longitudPacientesMasUno=this.listaPeliculas.size();
        int numeroAleatorio= random.nextInt(10000);
        String id=String.format("P%d%d%d%d",anoActual,mesActual,longitudPacientesMasUno,numeroAleatorio);
        return id;
    }

    public void eliminarPelicula (String idPelicula){
        for(Pelicula pelicula : this.listaPeliculas){
            if(pelicula.getId().equals(idPelicula)){
                this.listaPeliculas.remove(pelicula);
                return;
            }
        }
    }

    


    public void aniadirCliente (Cliente cliente){
        this.listaClientes.add(cliente);
        this.listaUsuarios.add(cliente);
    }

    public void aniadirPelicula (Pelicula pelicula){
        this.listaPeliculas.add(pelicula);
            }

            public void mostrarClientes() {
                if (this.listaClientes.isEmpty()){
                    System.out.println("No hay clientes registrados: ");
                    return;
                }
                System.out.println("\n----LISTA DE CLIENTES: ");
                for (Cliente cliente : this.listaClientes){
                    System.out.println(cliente.mostrarInformacion());
                }
            }


            public void mostrarPeliculas (){
                if (this.listaPeliculas.isEmpty()){
                    System.out.println("No hay peliculas registradas: ");
                    return;
                }
                System.out.println("\n---LISTA DE PELICULAS: -----");
                for (Pelicula pelicula : this.listaPeliculas){
                    System.out.println(pelicula.mostrarDatosPelicula());
                }
            }



  /*public void VerCatalogoDePeliculas(){

    ArrayList<Pelicula> peliculas = Cine.verPeliculasPorAdmin(Admin.getId());

if (peliculas.isEmpty()) {
    System.out.println("No tienes películas el catalogo.");
} else {
    for (Pelicula pelicula : peliculas) {
        System.out.println(pelicula);
    }
}

  } */





 public void mostrarCatalogoPeliculas() {
    if (this.listaPeliculas.isEmpty()) {
        System.out.println("No hay películas en el catálogo.");
        return;
    }
    System.out.println("\n----CATÁLOGO DE PELÍCULAS: ");
    for (Pelicula pelicula : this.listaPeliculas) {
        System.out.println(pelicula);
    }
}
    





    }







    
 


